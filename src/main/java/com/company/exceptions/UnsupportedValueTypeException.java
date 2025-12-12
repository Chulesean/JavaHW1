package com.company.exceptions;

public class UnsupportedValueTypeException extends DocumentException{
    public UnsupportedValueTypeException(String valueType) {
        super("Unsupported value " + valueType);
    }
}
