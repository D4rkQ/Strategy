package com.company;

import java.time.LocalDate;

/**
 * Created by SAILMA on 06.04.2017.
 */
public interface TaxStrategy {

    LocalDate getBillDate();
    int getBillNo();
    Receiver getBillRec();
    String toString();

}
