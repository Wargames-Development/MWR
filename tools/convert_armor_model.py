import os
import sys
import argparse
import tempfile
import subprocess
import shutil

# === Helper: Run Blender Script ===
def run_blender_cleaner(input_obj):
    blender_script = """
import bpy
import sys
import os

argv = sys.argv
argv = argv[argv.index("--") + 1:]
input_path = argv[0]
output_path = argv[1]

# Clean Blender state
bpy.ops.wm.read_factory_settings(use_empty=True)
bpy.ops.import_scene.obj(filepath=input_path)

# Get all mesh objects
mesh_objects = [obj for obj in bpy.context.scene.objects if obj.type == 'MESH']
if not mesh_objects:
    print("No mesh objects found.")
    sys.exit(1)

# Select and activate
for obj in mesh_objects:
    obj.select_set(True)
bpy.context.view_layer.objects.active = mesh_objects[0]

# Apply transforms and normals
bpy.ops.object.transform_apply(location=True, rotation=True, scale=True)
bpy.ops.object.mode_set(mode='EDIT')
bpy.ops.mesh.select_all(action='SELECT')
bpy.ops.mesh.normals_make_consistent(inside=False)
bpy.ops.mesh.quads_convert_to_tris()
bpy.ops.mesh.remove_doubles(threshold=0.0001)
bpy.ops.object.mode_set(mode='OBJECT')

# Export cleaned OBJ
bpy.ops.export_scene.obj(filepath=output_path, use_selection=True)
print("Blender cleanup done.")
    """
    
    with tempfile.NamedTemporaryFile(delete=False, suffix=".py", mode='w', encoding='utf-8') as temp_script:
        temp_script.write(blender_script)
        temp_script_path = temp_script.name

    output_obj = input_obj.replace(".obj", "_cleaned.obj")
    try:
        subprocess.run([
            "blender", "--background", "--python", temp_script_path, "--",
            os.path.abspath(input_obj),
            os.path.abspath(output_obj)
        ], check=True)
    finally:
        os.remove(temp_script_path)

    return output_obj

# === Helper: Deduplicate OBJ Groups ===
def deduplicate_obj(obj_path):
    group_counts = {}
    new_lines = []
    renaming_log = []

    with open(obj_path, 'r', encoding='utf-8') as f:
        for line in f:
            if line.startswith("o "):
                group_name = line.strip().split(" ", 1)[1]
                count = group_counts.get(group_name, 0)
                new_group = f"{group_name}_{count}" if count > 0 else group_name
                if count > 0:
                    renaming_log.append(f"{group_name} → {new_group}")
                group_counts[group_name] = count + 1
                new_lines.append(f"o {new_group}\n")
            else:
                new_lines.append(line)

    with open(obj_path, 'w', encoding='utf-8') as out_obj:
        out_obj.writelines(new_lines)

    return sorted(group_counts.keys()), renaming_log

# === Helper: Generate Java Class ===
def write_java_class(class_name, group_names, output_dir):
    path = os.path.join(output_dir, class_name + ".java")
    with open(path, 'w') as f:
        f.write("public class " + class_name + " {\n")
        for name in group_names:
            const_name = name.upper().replace('-', '_').replace('.', '_')
            f.write(f"    public static final String {const_name} = \"{name}\";\n")
        f.write("}\n")
    print(f"Java class written to: {path}")

# === Main ===
def main():
    parser = argparse.ArgumentParser(description="Convert and clean Blockbench-exported OBJ armor models.")
    parser.add_argument("input", help="Path to original OBJ file")
    parser.add_argument("--java", help="Optionally output a Java group mapping class")
    parser.add_argument("--keep-temp", action="store_true", help="Keep intermediate cleaned OBJ")
    args = parser.parse_args()

    input_path = args.input
    if not os.path.isfile(input_path):
        print("Input file does not exist.")
        sys.exit(1)

    print("Cleaning model in Blender...")
    cleaned_path = run_blender_cleaner(input_path)

    print("Deduplicating groups...")
    group_names, log = deduplicate_obj(cleaned_path)
    if log:
        print("Renamed duplicate groups:")
        for line in log:
            print("  ", line)
    else:
        print("No duplicate groups found.")

    print("Groups:")
    for name in group_names:
        print("  -", name)

    if args.java:
        out_dir = os.path.join(os.path.dirname(__file__), "generated")
        os.makedirs(out_dir, exist_ok=True)
        write_java_class(args.java, group_names, out_dir)

    if not args.keep_temp:
        final_path = input_path.replace(".obj", "_final.obj")
        shutil.move(cleaned_path, final_path)
        print(f"Final OBJ: {final_path}")
    else:
        print(f"Cleaned OBJ kept: {cleaned_path}")

if __name__ == "__main__":
    main()