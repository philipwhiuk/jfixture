package com.flextrade.jfixture.mockito.testtypes;

public interface OrderInterface {
    public String getSymbol();
    public void setSymbol(String symbol);

    public int getSize();
    public void setSize(int size);

    public double getPrice();
    public void setPrice(double price);

    public void writeToDatabase();
}
