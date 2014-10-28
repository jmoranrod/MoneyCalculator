package model;

public class Exchange {
    private final Currency amount;
    private final Money money[];

    public Exchange(Currency amount, Money[] money) {
        this.amount = amount;
        this.money = money;
    }

    public Currency getAmount() {
        return amount;
    }

    public Money[] getMoney() {
        return money;
    }
    
    
}
