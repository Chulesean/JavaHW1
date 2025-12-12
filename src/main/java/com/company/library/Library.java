package com.company.library;

import com.company.documents.Document;
import com.company.exceptions.DuplicateIdException;
import com.company.exceptions.DocumentNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Library<T extends Document> {
    private final Map<String, T> documents = new HashMap<>();
    private final Class<T> documentClass;

    public Library(Class<T> documentClass) {
        this.documentClass = documentClass;
    }

    // XÓA @Nonnull
    public void put(T document) throws DuplicateIdException {
        String id = document.getId();
        if (documents.containsKey(id)) {
            throw new DuplicateIdException(id);
        }
        documents.put(id, document);
    }

    // XÓA @Nonnull cho parameter và @NotNull cho return type
    public T get(String id) throws DocumentNotFoundException {
        T document = documents.get(id);
        if (document == null) {
            throw new DocumentNotFoundException(id);
        }
        return document;
    }

    // XÓA @Nonnull
    public T remove(String id) throws DocumentNotFoundException {
        if (!documents.containsKey(id)) {
            throw new DocumentNotFoundException(id);
        }
        return documents.remove(id);
    }

    // XÓA @Nonnull
    public boolean contains(String id) {
        return documents.containsKey(id);
    }

    public int size() {
        return documents.size();
    }

    public Class<T> getDocumentClass() {
        return documentClass;
    }
}