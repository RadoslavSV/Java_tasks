package model.com;

import java.io.Serializable;

public class TradeProduct implements Serializable, ITradeService {
    private Currency[] moneyToTrade;

    public synchronized Currency[] getMoneyToTrade() {
        return this.moneyToTrade;
    }

    public synchronized void setMoneyToTrade(Currency[] moneyToTrade) {
        if(moneyToTrade!=null) this.moneyToTrade = moneyToTrade;
    }

    public TradeProduct() {
        Currency c1 = new Currency(Money.EUR_USD, 1.130);
        Currency c2 = new Currency(Money.GBP_USD, 1.65);
        Currency c3 = new Currency(Money.USD_JPY, 107.102);
        Currency c4 = new Currency(Money.USD_RUB, 34.37);

        Currency[] arr = new Currency[]{c1, c2, c3, c4};
        setMoneyToTrade(arr);
    }

    @Override
    public Currency[] getTrade() {
        return getMoneyToTrade();
    }
}
