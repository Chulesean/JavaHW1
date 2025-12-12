package com.company.documents;

public abstract class Document {
    protected String id;
    protected String documentType;

    public Document(String id, String documentType) {
        this.id = id;
        this.documentType = documentType;
    }

    public String getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public abstract void printFields();
}
