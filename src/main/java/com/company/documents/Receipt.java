package com.company.documents;

public class Receipt extends Document {
    private Integer moneyAmount;

    public Receipt(String id, Integer moneyAmount){
        super(id, "RECEIPT");
        this.moneyAmount = moneyAmount;
    }
    public Integer getMoneyAmount(){
        return moneyAmount;
    }
    @Override
    public void printFields() {
        System.out.println("Class: RECEIPT");
        System.out.println("money_amount: " + (moneyAmount != null ? moneyAmount: "null"));
        System.out.println("id: " + id);
        System.out.println("document_type: " + documentType);
    }
}
