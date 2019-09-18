package com.isc.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.isc.common.config.constant.RegexConstant.REGEX_VARIABLE_NAME_JAVA;
import static com.isc.common.config.constant.StringFormatConstant.*;
import static java.util.stream.Collectors.toMap;

public class StringUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static JSONParser parser = new JSONParser();

    public static String fillDataToStringInterpolation(String stringInterpolation, Object... data) {
        Map<String, String> variable = extractVariable(stringInterpolation);
        Map<String, String> flattenData = flattenObjects(data);
        AtomicReference<String> string = new AtomicReference<>(stringInterpolation);
        variable.entrySet().stream().forEach(entry -> {
            String value = flattenData.getOrDefault(entry.getKey(), "");
            string.set(string.get().replace(entry.getValue(), value));
        });

        return string.toString();
    }

    private static Map<String, String> flattenObjects(Object... data) {

        return Stream.of(data).map(object -> {
            try {
                String jsonString = objectMapper.writeValueAsString(object);
                return flattenObject((JSONObject) parser.parse(jsonString));
            } catch (Exception e) {
                return new HashMap<String, String>();
            }
        }).flatMap(map -> map.entrySet().stream())
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v2));

    }

    private static Map<String, String> flattenObject(JSONObject object) {
        Map<String, String> result = new HashMap<>();
        object.keySet().forEach(key -> {
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                flattenArray((JSONArray) value).forEach((keyFlatten, valueFlatten) -> result.put(String.format(SUB_KEY, key, keyFlatten), valueFlatten));
            }

            if (value instanceof JSONObject) {
                flattenObject((JSONObject) value).forEach((keyFlatten, valueFlatten) -> result.put(String.format(SUB_KEY, key, keyFlatten), valueFlatten));
            }

            result.put(key.toString(), value.toString());
        });

        return result;
    }

    private static Map<String, String> flattenArray(JSONArray array) {
        Map<String, String> result = new HashMap<>();

        for (int i = 0; i < array.size(); ++i) {
            int index = i;
            Object element = array.get(i);
            if (element instanceof JSONArray) {
                flattenArray((JSONArray) element).forEach((keyFlatten, valueFlatten) -> result.put(String.format(INDEX_SUB_KEY, index, keyFlatten), valueFlatten));
            }

            if (element instanceof JSONObject) {

                flattenObject((JSONObject) element).forEach((keyFlatten, valueFlatten) -> result.put(String.format(INDEX_SUB_KEY, index, keyFlatten), valueFlatten));
            }

            result.put(String.format(INDEX_KEY, index), element.toString());

        }

        return result;
    }

    private static Map<String, String> extractVariable(String stringInterpolation) {
        Map<String, String> variable = new HashMap<>();

        Pattern pattern = Pattern.compile(REGEX_VARIABLE_NAME_JAVA);

        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher(stringInterpolation);

        while (m.find()) {
            if (m.groupCount() == 3) {
                variable.put(m.group(2), m.group());
            }
        }

        return variable;
    }
}
