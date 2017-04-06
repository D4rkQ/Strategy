package com.company;

/**
 * Created by sailerm on 31.03.2017.
 */
public class LineItem {

    private final String description;
    private final Money money;
    private final int amount;

    public LineItem(String description, Money money, int amount) {
        this.description = description;
        this.money = money;
        this.amount = amount;
    }

    public double sum() {
        return money.getValue()*amount;

    }

    @Override
    public String toString() {
        return "LineItem{" +
                "description='" + description + '\'' +
                ", money=" + money +
                ", amount=" + amount +
                '}';
    }
}
