package model;

public class Exchange {
    private final Money money;
    private final Currency currency;

    public Exchange(Money amount, Currency currency) {
        this.money = amount;
        this.currency = currency;
    }

    public Money getMoney() {
        return money;
    }

    public Currency getCurrency() {
        return currency;
    }
    
}
