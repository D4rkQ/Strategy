package com.company;

/**
 * Created by Max on 19.03.2017.
 */
public class Money {

    private final long euro;
    private final int cent;


    public Money(long euro, int cent) throws Exception {
        if (String.valueOf(cent).length()>2)
            throw new Exception();

        this.euro = euro;
        this.cent = cent;
    }

    public Money add(Money a) throws Exception {
        int centSol=0;
        long euroSol=0;
        centSol = a.getCent()+this.getCent();
        euroSol = a.getEuro()+this.getEuro();

        if (centSol > 99) {
            euroSol++;
            centSol -= 100;
        }
        return new Money(euroSol, centSol);
    }

    public Money subtract(Money a) throws Exception {
        int centSol=0;
        long euroSol=0;
        centSol = this.getCent()-a.getCent();
        euroSol = this.getEuro()-a.getEuro();

        if (centSol < 0) {
            euroSol--;
            centSol += 100;
        }
        return new Money(euroSol, centSol);
    }

    public Money mult(int fac) throws Exception {
        //Nur Ganzzahlig erlaub; To do Centbeträge

        int centSol=0;
        int tmp=0;
        long euroSol=0;
        centSol = this.getCent()*fac;
        euroSol = this.getEuro()*fac;

        if (centSol > 99) {

            tmp = centSol/100;
            euroSol += tmp;
            centSol -= (tmp*100);
        }


        return new Money(euroSol, centSol);
    }


    public double getValue() {
        return (cent/100.0)+euro;
    }

    public long getEuro() {
        return euro;
    }

    public int getCent() {
        return cent;
    }

    @Override
    public String toString() {
        return euro + "," + cent;


    }
}
