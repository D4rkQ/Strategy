package com.company;

/**
 * Created by SAILMA on 13.04.2017.
 */
public class SimpleTax implements TaxStrategy {


    @Override
    public Money calcTax(Invoice invoice) {

        Money grossInvoiceValue = invoice.netValue().mult(1.19);

        return grossInvoiceValue;

    }
}
