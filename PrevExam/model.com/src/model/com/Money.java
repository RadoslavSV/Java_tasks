package model.com;

public enum Money {
    EUR_USD(1),
    GBP_USD(2),
    USD_JPY(3),
    USD_RUB(4);

    private final int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}