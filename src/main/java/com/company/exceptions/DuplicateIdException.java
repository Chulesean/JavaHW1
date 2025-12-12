package com.company.exceptions;

public class DuplicateIdException extends DocumentException {
    public DuplicateIdException(String id) {
        super("Duplicate ID: " + id);
    }
}