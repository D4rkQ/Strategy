package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sailerm on 31.03.2017.
 */
public class InvoiceBuilder {


    private final List<LineItem> ListOfLineItems = new ArrayList<LineItem>();

    public void addLineItem( LineItem lineItem ) {
        this.ListOfLineItems.add( lineItem );
    }

    public void clearLineItems() {
        this.ListOfLineItems.clear();
    }

    public Invoice create() {
        return new Invoice(ListOfLineItems);
    }
}
