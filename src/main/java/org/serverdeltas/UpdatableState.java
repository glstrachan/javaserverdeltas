package org.serverdeltas;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class UpdatableState {
    private Set<Field> deltas = new HashSet<Field>();

    // Gets all the fields of the object that have been changed since the last call to getDelta()
    // Shoves them all in a String with the field name and that fields data
    public String getDelta() {
        StringBuilder delta = new StringBuilder();
        delta.append("\"").append(getClass().getName()).append("\": {");

        Iterator<Field> iterator = deltas.iterator();

        while (iterator.hasNext()) {
            Field field = iterator.next();
            delta.append("\"").append(field.getName()).append("\": ");

            field.setAccessible(true);

            Class<?> type = field.getType();

            try {
                delta.append(serializeValue(type, field.get(this)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (iterator.hasNext()) delta.append(", ");
        }

        delta.append("}");

        deltas.clear();

        return delta.toString();
    }

    // Takes in a bunch of fields and their data and applies them to the object
    public void applyDelta(String delta) {
        deltas.clear();

        if (!delta.contains(getClass().getName())) return;
        delta = delta.replaceAll(".*\\{(.*?)\\}.*", "$1");

        String[] pairs = delta.split(",\\s*");

        for (int i = 0; i < pairs.length; i++) {
            String[] keyValue = pairs[i].split(":\\s*");
            String name = keyValue[0].trim().replaceAll("\"", "");

            try {
                Field field = getClass().getDeclaredField(name);
                field.setAccessible(true);
                field.set(this, deserializeValue(field.getType(), keyValue[1]));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String serializeValue(Class<?> type, Object value) {
        if (type.isPrimitive()) {
            return value.toString();
        } else if (type == String.class) {
            return "\"" + (String) value + "\"";
        }

        return "null";
    }

    private Object deserializeValue(Class<?> type, String value) {
        if (type.isPrimitive()) {
            if (type == int.class) {
                return Integer.parseInt(value);
            } else if (type == long.class) {
                return Long.parseLong(value);
            } else if (type == boolean.class) {
                return Boolean.parseBoolean(value);
            } else if (type == byte.class) {
                return Byte.parseByte(value);
            } else if (type == short.class) {
                return Short.parseShort(value);
            } else if (type == float.class) {
                return Float.parseFloat(value);
            } else if (type == double.class) {
                return Double.parseDouble(value);
            } else if (type == char.class) {
                return value.length() > 0 ? value.charAt(0) : null;
            }
        } else if (type == String.class) {
            return value.replaceAll("^\"|\"$", ""); // Removes surrounding quotes
        }

        return null;
    }

    // Should be used by all setters (whose fields we want in a delta) when setting fields
    // Modifies the set of deltas to include the field that was just set
    protected void setField(String name, Object value) {
        try {
            Field field = getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(this, value);

            deltas.add(field);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
