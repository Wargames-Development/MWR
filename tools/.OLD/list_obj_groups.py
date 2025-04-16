import os

def list_obj_groups_from_input():
    obj_path = input("Enter the path to your .obj file: ").strip().strip('"')

    if not os.path.isfile(obj_path):
        print("❌ File not found.")
        return

    group_names = []
    with open(obj_path, 'r', encoding='utf-8') as file:
        for line in file:
            if line.startswith("o "):
                group_name = line.strip().split(" ", 1)[1]
                group_names.append(group_name)

    if not group_names:
        print("⚠️ No object groups (o ...) found in this file.")
        return

    # Prepare output path
    input_filename = os.path.basename(obj_path)
    base_name = os.path.splitext(input_filename)[0]
    output_filename = f"objects_{base_name}.txt"
    output_path = os.path.join(os.path.dirname(__file__), output_filename)

    # Write to file
    with open(output_path, 'w', encoding='utf-8') as out_file:
        for name in group_names:
            out_file.write(name + '\n')

    print(f"✅ Found {len(group_names)} object groups.")
    print(f"📝 Written to: {output_path}")

# Run it
if __name__ == "__main__":
    list_obj_groups_from_input()
