package com.company.exceptions;

public class InvalidDocumentTypeException extends DocumentException {
    public InvalidDocumentTypeException(String docType) {
        super("Invalid document type: " + docType);
    }
}