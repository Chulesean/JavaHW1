package com.company.documents;

public class Resume extends Document{
    private String name;

    public Resume(String id, String name){
        super(id, "RESUME");
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public void printFields() {
        System.out.println("Class: RESUME");
        System.out.println("name: " + (name != null ? name : "null"));
        System.out.println("id: " + id);
        System.out.println("document_type: " + documentType);
    }
}
