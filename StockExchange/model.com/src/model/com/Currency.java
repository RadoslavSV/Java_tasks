package model.com;

import java.io.Serializable;
import java.util.Random;
import java.time.LocalTime;

public class Currency implements Serializable {
    private Money currencyCode;
    private double exchange;
    private static Random rand = new Random();

    public Currency(Money currencyCode, double exchange) {
        setCurrencyCode(currencyCode);
        setExchange(exchange);
    }

    public Currency(Currency other) {
        this(other.currencyCode, other.exchange);
        ChangeExchangeRate();
    }

    public Money getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(Money currencyCode) {
        if(currencyCode!=null) this.currencyCode = currencyCode;
    }

    public double getExchange() {
        return this.exchange;
    }

    public void setExchange(double exchange) {
        if(exchange>0) this.exchange = exchange;
    }

    @Override
    public String toString() {
        return String.format("%s  %.4f Time:%02d:%02d:%02d",
                getCurrencyCode(),
                getExchange(),
                LocalTime.now().getHour(),
                LocalTime.now().getMinute(),
                LocalTime.now().getSecond());
    }

    public void ChangeExchangeRate() {
        double lwr = getExchange() - 0.03*getExchange();
        double upr = getExchange() + 0.03*getExchange();
        double newExchange = rand.nextDouble(lwr, upr + 0.0001);

        setExchange(newExchange);
    }

//    public static void main(String[] args) {
//        Currency c1 = new Currency(Money.EUR_USD, 1.8042);
//        System.out.println(c1);
//        Currency c2 = new Currency(c1);
//        System.out.println(c2);
//    }
}