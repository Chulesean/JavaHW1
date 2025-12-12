package com.company.parser;

import com.company.documents.*;
import com.company.exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class DocumentParserTest {
    @TempDir
    Path tempDir;

    @Test
    void testParseContract() throws Exception {
        String json = "{\"cost\": 5, \"date\": \"2023-01-01\", \"id\": \"A1\", \"document_type\": \"CONTRACT\"}";
        Path file = tempDir.resolve("contract.json");
        Files.writeString(file, json);

        DocumentParser parser = new DocumentParser();
        Document doc = parser.parseFile(file.toString());

        assertTrue(doc instanceof Contract);
        Contract contract = (Contract) doc;
        assertEquals("A1", contract.getId());
        assertEquals(5, contract.getCost());
    }

    @Test
    void testParseReceipt() throws Exception {
        String json = "{\"money_amount\": 100, \"id\": \"R1\", \"document_type\": \"RECEIPT\"}";
        Path file = tempDir.resolve("receipt.json");
        Files.writeString(file, json);

        DocumentParser parser = new DocumentParser();
        Document doc = parser.parseFile(file.toString());

        assertTrue(doc instanceof Receipt);
        Receipt receipt = (Receipt) doc;
        assertEquals("R1", receipt.getId());
        assertEquals(100, receipt.getMoneyAmount());
    }

    @Test
    void testParseMissingDocumentType() throws Exception {
        String json = "{\"id\": \"A1\"}";
        Path file = tempDir.resolve("missing.json");
        Files.writeString(file, json);

        DocumentParser parser = new DocumentParser();
        assertThrows(MissingFieldException.class, () -> parser.parseFile(file.toString()));
    }
}
