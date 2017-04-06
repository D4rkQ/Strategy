package com.company;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by SAILMA on 06.04.2017.
 */
public abstract class InvoiceHeader {
    private final LocalDate billDate;
    private final String billNo;
    private final Receiver billRec;

    public InvoiceHeader(String billNo, Receiver billRec) {
        this.billDate = LocalDate.now();
        this.billNo = billNo;
        this.billRec = billRec;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "billDate=" + billDate +
                ", billNo='" + billNo + '\'' +
                ", billRec=" + billRec +
                '}';
    }
}
