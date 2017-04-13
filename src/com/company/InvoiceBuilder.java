package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sailerm on 31.03.2017.
 */
public class InvoiceBuilder {


    private final List<LineItem> listOfLineItems = new ArrayList<LineItem>();
    private InvoiceHeader invoiceHeader;
    private final InvoiceHeaderFactory fac = new InvoiceHeaderFactory();

    public void addLineItem( LineItem lineItem ) {
        this.listOfLineItems.add( lineItem );
    }

    public void clearLineItems() {
        this.listOfLineItems.clear();
    }

    public Invoice createDefault(Receiver receiver) {

        invoiceHeader = fac.createDefaultInvoiceHeader(receiver);

        return new Invoice(listOfLineItems, invoiceHeader);
    }

    public Invoice createBackdate(Receiver receiver) {

        invoiceHeader = fac.createBackdateInvoiceHeader(receiver);

        return new Invoice(listOfLineItems, invoiceHeader);
    }
}
