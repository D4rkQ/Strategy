package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sailerm on 31.03.2017.
 */
public class Invoice {

    private final List<LineItem> listOfLineItems = new ArrayList<LineItem>();

    public Invoice(List<? extends LineItem> listOfLineItems) {
        this.listOfLineItems.addAll(listOfLineItems);
    }

    public double sum() {
        double tmp=0;
        for (LineItem x: listOfLineItems) {
            tmp += x.sum();
        }
        return tmp;
    }

    public List<LineItem> getLineItems() {
        return Collections.unmodifiableList(listOfLineItems);
    }


}
