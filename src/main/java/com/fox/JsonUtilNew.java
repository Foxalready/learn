package com.fox;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.text.SimpleDateFormat;
import java.util.List;

public class JsonUtilNew {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper objectMapper2 = new ObjectMapper();
    private static ObjectMapper objectMapper3 = new ObjectMapper();
    private static ObjectMapper objectMapper4 = new ObjectMapper();
    private static ObjectMapper objectMapper5 = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        objectMapper2.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper2.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        objectMapper3.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper3.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper3.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper3.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper4.setSerializationInclusion(Include.NON_NULL);
        objectMapper4.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper4.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper4.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper4.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper4.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        objectMapper5.setSerializationInclusion(Include.NON_NULL);
        objectMapper5.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper5.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper5.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper5.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper5.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //下划线转驼峰
        objectMapper5.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    public static String writeValueAsString(Object obj) {
        return writeValueAsString(obj, true);
    }

    public static String writeValueAsDateString(Object obj) {
        try {
            return objectMapper4.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("failed translate object to json", e);
        }
    }

    public static String writeValueAsString(Object obj, boolean ignoreNullField) {
        try {
            if (ignoreNullField) {
                return objectMapper.writeValueAsString(obj);
            } else {
                return objectMapper2.writeValueAsString(obj);
            }
        } catch (Exception e) {
            throw new RuntimeException("failed translate object to json", e);
        }
    }

    public static <T> T readValue(String json, Class<T> type) {
        return readValue(json, type, true);
    }

    public static Object readValue(String json, JavaType javaType) {
        try {
            return objectMapper4.readValue(json, javaType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T readValue(String json, TypeReference<T> valueType) {
        try {
            return objectMapper4.readValue(json, valueType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }


    /**
     * 下划线转驼峰可以使用这个
     * @param json json
     * @param valueType valueType
     * @param <T>
     * @return return
     */
    public static <T> T readValueWithCamel(String json, TypeReference<T> valueType) {
        try {
            return objectMapper5.readValue(json, valueType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }


    public static <T> T readValue(String json, Class<T> type, boolean isAllowNoField) {
        try {
            if (!isAllowNoField) {
                return objectMapper.readValue(json, type);
            } else {
                return objectMapper3.readValue(json, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T readValueByDate(String json, Class<T> type) {
        try {
            return objectMapper4.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> List<T> readValueByDate(String json, Class listClass, Class<T> type) {
        try {
            TypeFactory t = TypeFactory.defaultInstance();
            return objectMapper4.readValue(json, t.constructCollectionType(listClass, type));
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T readValue(JsonNode jsonNode, Class<T> type) {
        try {
            return objectMapper.readValue(writeValueAsString(jsonNode), type);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> List<T> readValue(String json, Class<?> listClass, Class<T> typeClass) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(listClass, typeClass);
        try {
            return objectMapper3.readValue(json, javaType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    public static JavaType constructParametricType(Class<?> parametrized, JavaType... parameterClasses) {
        return objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }
}
