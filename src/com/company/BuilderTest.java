package com.company;


import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

    @Test
   public void testMoney() throws Exception {
        Money m0 = new Money(1525);
        Money m1 = new Money(1211);
        Money m2;

        m2 = m0.add(m1);
        assertEquals(m2.asDouble(),27.36,0);
        System.out.println(m2);

        m2 = m2.subtract(m1);
        assertEquals(m2.asDouble(), 15.25,0);
        System.out.println(m2);

        m2 = m2.mult(5);
        assertEquals(m2.asDouble(), 76.25,0);
        System.out.println(m2);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBuilder() throws Exception {
        InvoiceBuilder ib = new InvoiceBuilder();

        ib.addLineItem(new LineItem("Papier",new Money(1210),13));
        ib.addLineItem(new LineItem("Schere",new Money(588),3));
        ib.clearLineItems();
        ib.addLineItem(new LineItem("Papier2",new Money(1210),13));
        ib.addLineItem(new LineItem("Schere2",new Money(588),3));
        Invoice invoice1 = ib.createDefault(new Receiver("Hans", "Reutlingen"));

        System.out.println("Rechnugsbetrag = " + invoice1.netValue());

        for (LineItem x: invoice1.getLineItems()) {
            System.out.println(x);
        }

        //Nachträgliches löschen der Line Item Liste ist nicht erlaubt !! --> UnsupportedOperationException
        invoice1.getLineItems().clear();

    }

}
