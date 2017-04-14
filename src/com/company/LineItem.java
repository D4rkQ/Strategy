package com.company;

/**
 * Project: Strategy
 * Created by sailerm on 31.03.2017.
 */
public class LineItem {

    private final String description;
    private final Money money;
    private final int amount;

    LineItem(String description, Money money, int amount) {
        this.description = description;
        this.money = money;
        this.amount = amount;
    }

    Money sum()  {
        return money.mult(amount);

    }

    @Override
    public String toString() {
        return "LineItem{" +
                "description='" + description + '\'' +
                ", money=" + money +
                ", amount=" + amount +
                '}';
    }

    String getDescription() {
        return description;
    }

    public Money getMoney() {
        return money;
    }

    public int getAmount() {
        return amount;
    }
}
