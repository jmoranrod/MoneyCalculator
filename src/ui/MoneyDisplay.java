package ui;

import model.Money;

public interface MoneyDisplay {
    
    /*private final Money money;

    public MoneyDisplay(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }
    
    public void execute() {
        System.out.println(money +" "+money.getCurrency().getSymbol());
    }*/
    public void show(Money money);
}
