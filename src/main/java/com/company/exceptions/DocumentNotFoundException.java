package com.company.exceptions;

public class DocumentNotFoundException extends DocumentException {
    public DocumentNotFoundException(String id) {
        super("Document not found: " + id);
    }
}