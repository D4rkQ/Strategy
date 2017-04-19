package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: Strategy
 * Created by sailerm on 31.03.2017.
 */
public class Invoice {

    private final List<LineItem> listOfLineItems = new ArrayList<>();
    private final InvoiceHeader invoiceHeader;

    public TaxStrategy getCurrentStrategy() {
        return currentStrategy;
    }

    public void setCurrentStrategy(TaxStrategy currentStrategy) {
        this.currentStrategy = currentStrategy;
    }

    private volatile TaxStrategy currentStrategy;

    Invoice(List<? extends LineItem> listOfLineItems, InvoiceHeader invoiceHeader) {
        this.listOfLineItems.addAll(listOfLineItems);
        this.invoiceHeader = invoiceHeader;

        if (invoiceHeader.getBillRec().getAddress().contains("simple")) {
            this.currentStrategy = new SimpleTaxStrategy();
        } else if (invoiceHeader.getBillRec().getAddress().contains("complex")) {
            this.currentStrategy = new ComplexTaxStrategy();
        } else {
            //Wenn die Steuern nicht spezifiziert sind wird einfache Berechnung verwendet!
            this.currentStrategy = new SimpleTaxStrategy();
        }
    }

    Money netValue() {
        Money tmp = new Money(0);
        for (LineItem x: listOfLineItems) {
            tmp = tmp.add(x.sum());
        }
        return tmp;
    }

    Money grossValue(){
        return currentStrategy.calcTax(this);
    }

    List<LineItem> getLineItems() {
        return Collections.unmodifiableList(listOfLineItems);
    }

    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "listOfLineItems=" + listOfLineItems +
                ", invoiceHeader=" + invoiceHeader +
                '}';
    }
}
