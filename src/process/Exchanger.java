package process;

import model.ExchangeRate;
import model.Money;

public class Exchanger {
    
    private final ExchangeRate exchangeRate;
    private final Money money;

    public Exchanger(ExchangeRate exchangeRate, Money money) {
        this.exchangeRate = exchangeRate;
        this.money = money;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public Money getMoney() {
        return money;
    }
    
    public Money exchange(){
        return calculate(money, exchangeRate);
    }
    
    private Money calculate(Money money, ExchangeRate exchangeRate){
        return new Money(money.getAmount() * exchangeRate.getRate(), exchangeRate.getOut());
    }
}
