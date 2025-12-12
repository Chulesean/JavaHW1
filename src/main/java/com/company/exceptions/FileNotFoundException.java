package com.company.exceptions;

public class FileNotFoundException extends DocumentException {
    public FileNotFoundException(String fileName) {
        super("File not found " + fileName);
    }
}