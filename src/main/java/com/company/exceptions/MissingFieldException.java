package com.company.exceptions;

public class MissingFieldException extends DocumentException {
    public MissingFieldException(String fieldName) {
        super("Missing field " + fieldName);
    }
}