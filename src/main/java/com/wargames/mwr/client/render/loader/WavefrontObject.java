package com.wargames.mwr.client.render.loader;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * WavefrontObject V5
 * - OBJ loader for group-based rendering
 * - Supports o-groups and f v/vt faces
 */
public class WavefrontObject {

    public final Map<String, GroupObject> groupObjects = new LinkedHashMap<>();
    public final Map<Integer, float[]> vertices = new LinkedHashMap<>();
    public final Map<Integer, float[]> texCoords = new LinkedHashMap<>();

    public WavefrontObject(ResourceLocation objLocation) {
        loadObjModel(objLocation);
    }

    private void loadObjModel(ResourceLocation loc) {
        try {
            InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(loc).getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            GroupObject currentGroup = null;
            int vIndex = 1, vtIndex = 1;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("o ")) {
                    String groupName = line.substring(2).trim();
                    currentGroup = new GroupObject(groupName);
                    groupObjects.put(groupName, currentGroup);
                } else if (line.startsWith("v ")) {
                    String[] tokens = line.trim().split(" +");
                    float[] v = new float[] {
                            Float.parseFloat(tokens[1]),
                            Float.parseFloat(tokens[2]),
                            Float.parseFloat(tokens[3])
                    };
                    vertices.put(vIndex++, v);
                } else if (line.startsWith("vt ")) {
                    String[] tokens = line.trim().split(" +");
                    float[] vt = new float[] {
                            Float.parseFloat(tokens[1]),
                            1.0F - Float.parseFloat(tokens[2]) // Flip V axis
                    };
                    texCoords.put(vtIndex++, vt);
                } else if (line.startsWith("f ")) {
                    if (currentGroup != null) {
                        currentGroup.faces.add(line.trim());
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renderGroups(Set<String> groupNames) {
        for (Map.Entry<String, GroupObject> entry : groupObjects.entrySet()) {
            if (groupNames.contains(entry.getKey())) {
                entry.getValue().render(vertices, texCoords);
            }
        }
    }

    public static class GroupObject {
        public final String name;
        public final List<String> faces = new ArrayList<>();

        public GroupObject(String name) {
            this.name = name;
        }

        public void render(Map<Integer, float[]> vMap, Map<Integer, float[]> vtMap) {
            GL11.glBegin(GL11.GL_TRIANGLES);
            for (String face : faces) {
                String[] tokens = face.split(" ");
                for (int i = 1; i < tokens.length; i++) {
                    String[] parts = tokens[i].split("/");
                    int vIdx = Integer.parseInt(parts[0]);
                    int vtIdx = parts.length > 1 && !parts[1].isEmpty() ? Integer.parseInt(parts[1]) : -1;

                    float[] v = vMap.getOrDefault(vIdx, new float[]{0, 0, 0});
                    float[] vt = vtIdx != -1 ? vtMap.getOrDefault(vtIdx, new float[]{0, 0}) : new float[]{0, 0};

                    GL11.glTexCoord2f(vt[0], vt[1]);
                    GL11.glVertex3f(v[0], v[1], v[2]);
                }
            }
            GL11.glEnd();
        }
    }
}
