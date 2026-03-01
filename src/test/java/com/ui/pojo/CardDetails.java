package com.ui.pojo;

public class CardDetails {

    private String name;
    private String card_number;
    private String cvc;
    private String expiremonth;
    private String expireyear;

    public CardDetails(String name, String card_number, String cvc, String expiremonth, String expireyear) {
        this.name = name;
        this.card_number = card_number;
        this.cvc = cvc;
        this.expiremonth = expiremonth;
        this.expireyear = expireyear;
    }

    public String getName() {
        return name;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpiremonth() {
        return expiremonth;
    }

    public String getExpireyear() {
        return expireyear;
    }
}
