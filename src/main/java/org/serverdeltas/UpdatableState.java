package org.serverdeltas;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;

import java.util.regex.Pattern;

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
                delta.append(serializeObject(type, field.get(this)));
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
        if (!delta.contains(getClass().getName())) return;
        delta = delta.replaceAll(".*\\{(.*?)\\}.*", "$1");

        Pattern pattern = Pattern.compile("\"[a-z]+\":");

        String[] keys = pattern.matcher(delta).results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        String[] values = delta.split("\"[a-z]+\":");

        for(int i = 0; i < keys.length; i++) {
            String key = keys[i].replaceAll("[\":]", "");
            String value = values[i + 1].trim();
            if(value.endsWith(",")) value = value.substring(0, value.length() - 1);

            try {
                Field field = getClass().getDeclaredField(key);
                field.setAccessible(true);

                Class<?> type = field.getType();

                field.set(this, deserializeObject(type, value));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
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

    private String serializeObject(Class<?> type, Object object) {
        if (type.isPrimitive()) {
            return object.toString();
        } else if (type == String.class) {
            return "\"" + (String) object + "\"";
        } else if (type.isArray()) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");

            Class<?> componentType = type.getComponentType();
            int length = Array.getLength(object);
            for (int i = 0; i < length; i++) {
                Object element = Array.get(object, i);
                builder.append(serializeObject(componentType.isPrimitive() ? componentType : element.getClass(), element));

                if (i < length - 1) builder.append(", ");
            }

            builder.append("]");

            return builder.toString();
        }

        return "null";
    }

    private Object deserializeObject(Class<?> type, String object) {
        if (type.isPrimitive()) {
            if (type == int.class) {
                return Integer.parseInt(object);
            } else if (type == long.class) {
                return Long.parseLong(object);
            } else if (type == boolean.class) {
                return Boolean.parseBoolean(object);
            } else if (type == byte.class) {
                return Byte.parseByte(object);
            } else if (type == short.class) {
                return Short.parseShort(object);
            } else if (type == float.class) {
                return Float.parseFloat(object);
            } else if (type == double.class) {
                return Double.parseDouble(object);
            } else if (type == char.class) {
                return object.length() > 0 ? object.charAt(0) : null;
            }
        }
        else if (type == String.class) {
            return object.replaceAll("^\"|\"$", "");
        }
        else if (type.isArray()) {
            object = object.substring(1, object.length() - 1).replaceAll(" ", "");

            if(type.componentType().isPrimitive()) {
                String[] elements = object.split(",");

                Object array = Array.newInstance(type.componentType(), elements.length);

                for(int i = 0; i < elements.length; i++) {
                    Array.set(array, i, deserializeObject(type.componentType(), elements[i]));
                }

                return array;
            }
            else if(type.componentType().isArray()) {
                ArrayList<Object> elements = new ArrayList<Object>();
                StringBuilder element = new StringBuilder();

                int layer = 0;

                for(char c : object.toCharArray()) {
                    if(layer == 0 && c == ',') {
                        elements.add(deserializeObject(type.componentType(), element.toString()));
                        element = new StringBuilder();
                    }
                    else {
                        element.append(c);
                    }

                    if(c == '[') layer++;
                    else if(c == ']') layer--;
                }

                elements.add(deserializeObject(type.componentType(), element.toString()));

                Object array = Array.newInstance(type.componentType(), elements.size());

                for(int i = 0; i < elements.size(); i++) {
                    Array.set(array, i, elements.get(i));
                }

                return array;
            }
        }

        return null;
    }
}
