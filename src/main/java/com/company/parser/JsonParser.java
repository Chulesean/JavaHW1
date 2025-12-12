package com.company.parser;

import com.company.exceptions.InvalidJsonException;
import com.company.exceptions.UnsupportedValueTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static Map<String, Object> parse(String jsonString)
            throws InvalidJsonException, UnsupportedValueTypeException {

        Map<String, Object> result = new HashMap<>();
        jsonString = jsonString.trim();

        if (!jsonString.startsWith("{") || !jsonString.endsWith("}")) {
            throw new InvalidJsonException("JSON must start with { and end with }");
        }

        String content = jsonString.substring(1, jsonString.length() - 1).trim();
        if (content.isEmpty()) {
            return result;
        }

        String[] pairs = splitPairs(content);

        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            if (keyValue.length != 2) {
                throw new InvalidJsonException("Invalid key-value pair: " + pair);
            }

            String key = parseString(keyValue[0].trim());
            String valueStr = keyValue[1].trim();
            Object value = parseValue(valueStr);
            result.put(key, value);
        }

        return result;
    }

    private static String[] splitPairs(String content) throws InvalidJsonException {
        List<String> pairs = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inString = false;

        for (char c : content.toCharArray()) {
            if (c == '"' && (current.length() == 0 || current.charAt(current.length() - 1) != '\\')) {
                inString = !inString;
            }

            if (c == ',' && !inString) {
                pairs.add(current.toString().trim());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            pairs.add(current.toString().trim());
        }

        return pairs.toArray(new String[0]);
    }

    private static String parseString(String str) throws InvalidJsonException {
        if (!str.startsWith("\"") || !str.endsWith("\"")) {
            throw new InvalidJsonException("String must be quoted: " + str);
        }

        if (str.length() < 2) {
            throw new InvalidJsonException("Invalid string format: " + str);
        }

        return str.substring(1, str.length() - 1);
    }

    private static Object parseValue(String valueStr)
            throws UnsupportedValueTypeException, InvalidJsonException {

        if (valueStr.startsWith("\"") && valueStr.endsWith("\"")) {
            return parseString(valueStr);
        }

        if (valueStr.matches("-?\\d+")) {
            try {
                return Integer.parseInt(valueStr);
            } catch (NumberFormatException e) {
                throw new UnsupportedValueTypeException("Invalid integer format: " + valueStr);
            }
        }

        if (valueStr.equals("null")) {
            throw new UnsupportedValueTypeException("Null values are not supported");
        }

        if (valueStr.equals("true") || valueStr.equals("false")) {
            throw new UnsupportedValueTypeException("Boolean values are not supported: " + valueStr);
        }

        if (valueStr.matches("-?\\d+\\.\\d+")) {
            throw new UnsupportedValueTypeException("Floating point numbers are not supported: " + valueStr);
        }

        throw new UnsupportedValueTypeException("Unsupported value type: " + valueStr);
    }
}
