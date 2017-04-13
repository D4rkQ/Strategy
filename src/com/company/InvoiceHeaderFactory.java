package com.company;

import java.util.Date;

/**
 * Created by SAILMA on 06.04.2017.
 */
public class InvoiceHeaderFactory  {


    public InvoiceHeader createDefaultInvoiceHeader(Receiver receiver) {
        return new InvoiceHeaderDefault(receiver);
    }

    public InvoiceHeader createBackdateInvoiceHeader(Receiver receiver) {
        return new InvoiceHeaderBackdate(receiver);
    }
}
