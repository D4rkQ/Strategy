package com.company;

/**
 * Project: Strategy
 * Created by SAILMA on 13.04.2017.
 */
public class SimpleTaxStrategy implements TaxStrategy {


    @Override
    public Money calcTax(Invoice invoice) {
        return invoice.netValue().mult(1.19);
    }
}
