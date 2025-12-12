package com.company.parser;

import com.company.exceptions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    @Test
    void testParseValidJson() throws Exception {
        String json = "{\"name\": \"John\", \"age\": 30}";
        Map<String, Object> result = JsonParser.parse(json);

        assertEquals("John", result.get("name"));
        assertEquals(30, result.get("age"));
        assertEquals(2, result.size());
    }

    @Test
    void testParseInvalidJson() {
        String json = "{invalid json}";
        assertThrows(InvalidJsonException.class, () -> JsonParser.parse(json));
    }

    @Test
    void testParseFloatValue() {
        String json = "{\"price\": 19.99}";
        assertThrows(UnsupportedValueTypeException.class, () -> JsonParser.parse(json));
    }

    @Test
    void testParseNullValue() {
        String json = "{\"value\": null}";
        assertThrows(UnsupportedValueTypeException.class, () -> JsonParser.parse(json));
    }
}
