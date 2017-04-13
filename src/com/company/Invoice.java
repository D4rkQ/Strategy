package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sailerm on 31.03.2017.
 */
public class Invoice {

    private final List<LineItem> listOfLineItems = new ArrayList<LineItem>();
    private final InvoiceHeader invoiceHeader;

    public TaxStrategy getCurrentStrategy() {
        return currentStrategy;
    }

    public void setCurrentStrategy(TaxStrategy currentStrategy) {
        this.currentStrategy = currentStrategy;
    }

    private volatile TaxStrategy currentStrategy;

    public Invoice(List<? extends LineItem> listOfLineItems, InvoiceHeader invoiceHeader) {
        this.listOfLineItems.addAll(listOfLineItems);
        this.invoiceHeader = invoiceHeader;

        if (invoiceHeader.getBillRec().getAddress().contains("simple")) {
            this.currentStrategy = new SimpleTax();
        } else if (invoiceHeader.getBillRec().getAddress().contains("complex")) {
            this.currentStrategy = new ComplexTax();
        } else {
            //Wenn die Steuern nicht spezifiziert sind wird einfache Berechnung verwendet!
            this.currentStrategy = new SimpleTax();
        }
    }

    public Money netValue() {
        Money tmp = new Money(0);
        for (LineItem x: listOfLineItems) {
            tmp = tmp.add(x.sum());
        }
        return tmp;
    }

    public Money grossValue(){
        return currentStrategy.calcTax(this);
    }

    public List<LineItem> getLineItems() {
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
