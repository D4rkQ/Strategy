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

    public Invoice(List<? extends LineItem> listOfLineItems, InvoiceHeader invoiceHeader) {
        this.listOfLineItems.addAll(listOfLineItems);
        this.invoiceHeader = invoiceHeader;
    }

    public Money sum() throws Exception {
        Money tmp = new Money(0);
        for (LineItem x: listOfLineItems) {
            tmp = tmp.add(x.sum());
        }
        return tmp;
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
