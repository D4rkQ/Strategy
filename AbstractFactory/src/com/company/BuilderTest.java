package com.company;


import org.junit.*;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;


public class BuilderTest {

    @Test
   public void testMoney() throws Exception {
        Money m0 = new Money(15, 25);
        Money m1 = new Money(12, 11);
        Money m2;

        m2 = m0.add(m1);
        assertEquals(m2.getValue(),27.36,0);
        System.out.println(m2);

        m2 = m2.subtract(m1);
        assertEquals(m2.getValue(), 15.25,0);
        System.out.println(m2);

        m2 = m2.mult(5);
        assertEquals(m2.getValue(), 76.25,0);
        System.out.println(m2);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBuilder() throws Exception {
        InvoiceBuilder ib = new InvoiceBuilder();

        ib.addLineItem(new LineItem("Papier",new Money(12,10),13));
        ib.addLineItem(new LineItem("Schere",new Money(5,88),3));
        ib.clearLineItems();
        ib.addLineItem(new LineItem("Papier2",new Money(12,10),13));
        ib.addLineItem(new LineItem("Schere2",new Money(5,88),3));
        Invoice invoice1 = ib.create();

        System.out.println("Rechnugsbetrag = " + invoice1.sum() + " €");

        for (LineItem x: invoice1.getLineItems()) {
            System.out.println(x);
        }

        //Nachträgliches löschen der Line Item Liste ist nicht erlaubt !! --> UnsupportedOperationException
        invoice1.getLineItems().clear();

    }

}
