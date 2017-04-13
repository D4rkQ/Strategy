package com.company;

/**
 * Created by Max on 19.03.2017.
 */
public class Money {

    private final long cent;


    public Money(long cent){
        this.cent = cent;
    }

    public double asDouble() {
        return cent / 100.0;
    }

    public Money add(Money a) {
        return new Money(getCent() + a.getCent());
    }

    public Money subtract(Money a) {
        return new Money(getCent()-a.getCent());
    }

    public Money mult(double fac) {
        return new Money(Math.round(getCent()*fac));
    }

    public long getCent() {
        return cent;
    }

    @Override
    public String toString() {

        String s = ""+cent;
        String euroPart, centPart;
        centPart = s.substring(s.length()-2);
        euroPart = s.substring(0,s.length()-2);
        return euroPart +","+centPart +" €";


    }
}
