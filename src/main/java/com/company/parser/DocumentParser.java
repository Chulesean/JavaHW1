package com.company.parser;

import com.company.documents.*;
import com.company.exceptions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class DocumentParser {

    public Document parseFile(String filename)
            throws InvalidJsonException, MissingFieldException, FileNotFoundException,
            InvalidDocumentTypeException, UnsupportedValueTypeException {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));

            Map<String, Object> jsonData = JsonParser.parse(content);

            validateRequiredFields(jsonData);

            String id = (String) jsonData.get("id");
            String documentType = ((String) jsonData.get("document_type")).toUpperCase();

            return createDocument(id, documentType, jsonData);

        } catch (IOException e) {
            throw new FileNotFoundException(filename);
        }
    }

    private void validateRequiredFields(Map<String, Object> data)
            throws MissingFieldException, InvalidJsonException {
        if (!data.containsKey("document_type")) {
            throw new MissingFieldException("document_type");
        }
        if (!data.containsKey("id")) {
            throw new MissingFieldException("id");
        }

        Object docType = data.get("document_type");
        Object id = data.get("id");

        if (!(docType instanceof String)) {
            throw new InvalidJsonException("document_type must be a string");
        }
        if (!(id instanceof String)) {
            throw new InvalidJsonException("id must be a string");
        }
    }

    private Document createDocument(String id, String documentType, Map<String, Object> data)
            throws InvalidDocumentTypeException {

        switch (documentType) {
            case "CONTRACT":
                return createContract(id, data);
            case "RECEIPT":
                return createReceipt(id, data);
            case "RESUME":
                return createResume(id, data);
            default:
                throw new InvalidDocumentTypeException(documentType);
        }
    }

    private Contract createContract(String id, Map<String, Object> data) {
        Integer cost = data.containsKey("cost") ? (Integer) data.get("cost") : null;
        String date = data.containsKey("date") ? (String) data.get("date") : null;
        return new Contract(id, cost, date);
    }

    private Receipt createReceipt(String id, Map<String, Object> data) {
        Integer moneyAmount = data.containsKey("money_amount") ? (Integer) data.get("money_amount") : null;
        return new Receipt(id, moneyAmount);
    }

    private Resume createResume(String id, Map<String, Object> data) {
        String name = data.containsKey("name") ? (String) data.get("name") : null;
        return new Resume(id, name);
    }
}
