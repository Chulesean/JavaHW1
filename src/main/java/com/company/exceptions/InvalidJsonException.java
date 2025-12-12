package com.company.exceptions;

public class InvalidJsonException extends DocumentException {
    public InvalidJsonException (String jsonError) {
        super("Invalid document type: " + jsonError);
    }
}
