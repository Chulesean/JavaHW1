package com.company.documents;

public class Contract extends Document{
    private Integer cost;
    private String date;

    public Contract(String id, Integer cost, String date){
        super(id, "CONTRACT");
        this.cost = cost;
        this.date = date;
    }
    public Integer getCost() {
        return cost;
    }
    public String getDate() {
        return date;
    }
    @Override
    public void printFields() {
        System.out.println("Class: CONTRACT");
        System.out.println("cost: " + (cost != null ? cost : "null"));
        System.out.println("date: " + (date != null ? date : "null"));
        System.out.println("id: " + id);
        System.out.println("document_type: " + documentType);
    }
}
