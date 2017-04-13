package com.company;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by SAILMA on 06.04.2017.
 */
public interface InvoiceHeader {

    LocalDate getBillDate();
    int getBillNo();
    Receiver getBillRec();
    String toString();

}
