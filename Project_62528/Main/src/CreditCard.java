public class CreditCard extends Tokenizer {
    private String number;
    private String token;

    public CreditCard() {}

    public CreditCard(String number){
        setNumber(number);
        setToken(cardToToken(number));
    }

    public String getNumber() {
        return this.number;
    }

    public String getToken() {
        return this.token;
    }

    public void setNumber(String number) {
        if(isCardValid(number)) this.number = number;
        else System.out.println("INVALID CARD NUMBER");
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("Credit card:%s with token:%s", getNumber(), getToken());
    }
}
