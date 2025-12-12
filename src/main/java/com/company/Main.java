package com.company;

import com.company.documents.Document;
import com.company.exceptions.DocumentException;
import com.company.parser.DocumentParser;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar document-parser.jar <filename>");
            System.err.println("Example: java -jar document-parser.jar contract.json");
            System.exit(1);
        }

        String filename = args[0];
        DocumentParser parser = new DocumentParser();

        try {
            Document document = parser.parseFile(filename);

            document.printFields();

        } catch (DocumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
