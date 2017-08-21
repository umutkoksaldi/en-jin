package com.umut.enjin;

import org.lwjgl.BufferUtils;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

/* This class prepares the floating point values inside the vector3f of the vertex in order to be loaded into opengl
IMPORTANT: Upon each modification of the vertex class the createFlippedBuffer method needs to be adjusted otherwise
the changes will NOT take effect
 */
public class Util
{
    public static FloatBuffer createFloatBuffer(int size) {
        return BufferUtils.createFloatBuffer(size);
    }

    public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
        FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);

        for(int i = 0; i < vertices.length; i++) {
            buffer.put(vertices[i].getPos().getX());
            buffer.put(vertices[i].getPos().getY());
            buffer.put(vertices[i].getPos().getZ());
            buffer.put(vertices[i].getTexCoord().getX());
            buffer.put(vertices[i].getTexCoord().getY());
        }

        buffer.flip();

        return buffer;
    }

    public static FloatBuffer createFlippedBuffer(Matrix4f value) {
        FloatBuffer buffer = createFloatBuffer(16);

        for (int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                buffer.put(value.get(i,j));

        buffer.flip();

        return buffer;
    }

    public static IntBuffer createIntBuffer(int size) {
        return BufferUtils.createIntBuffer(size);
    }

    public static IntBuffer createFlippedBuffer(int... values) {
        IntBuffer buffer = createIntBuffer(values.length);
        buffer.put(values);
        buffer.flip();
        return buffer;
    }

    public static String[] removeEmptyStrings(String[] data) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if(!data[i].equals(""))
                result.add(data[i]);
        }

        String[] res = new String[result.size()];
        result.toArray(res);

        return res;
    }

    public static int[] toIntArray(Integer[] data) {
        int[] result = new int[data.length];

        for(int i = 0; i < result.length; i++) {
            result[i] = data[i].intValue();
        }

        return result;
    }
}
