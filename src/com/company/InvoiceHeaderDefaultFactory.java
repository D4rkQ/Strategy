package com.company;

import java.util.Date;

/**
 * Created by SAILMA on 06.04.2017.
 */
public class InvoiceHeaderDefaultFactory {

    public InvoiceHeader createIH(){

        return new InvoiceHeaderDefault("12354",new Receiver("dfadf","dfadfa"));
    }

}
