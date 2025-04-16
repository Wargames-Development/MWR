import bpy
import os

def clean_model_for_minecraft():
    # Deselect everything first
    bpy.ops.object.select_all(action='DESELECT')

    # Get all mesh objects in the scene
    mesh_objects = [obj for obj in bpy.context.scene.objects if obj.type == 'MESH']
    
    if not mesh_objects:
        print("❌ No mesh objects found.")
        return

    # Select all mesh objects and set the first one as active
    for obj in mesh_objects:
        obj.select_set(True)
    bpy.context.view_layer.objects.active = mesh_objects[0]

    # Apply transforms
    bpy.ops.object.transform_apply(location=True, rotation=True, scale=True)

    # Enter edit mode
    bpy.ops.object.mode_set(mode='EDIT')
    bpy.ops.mesh.select_all(action='SELECT')

    # Recalculate normals
    bpy.ops.mesh.normals_make_consistent(inside=False)

    # Triangulate
    bpy.ops.mesh.quads_convert_to_tris()

    # Merge stray vertices
    bpy.ops.mesh.remove_doubles(threshold=0.0001)

    # Back to object mode
    bpy.ops.object.mode_set(mode='OBJECT')

    print("✅ Model cleaned! You can now export via File > Export > Wavefront (.obj)")

# Run it
clean_model_for_minecraft()
