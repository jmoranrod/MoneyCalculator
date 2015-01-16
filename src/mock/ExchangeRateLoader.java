package mock;

import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoader implements persistence.ExchangeRateLoader {
    
    @Override
    public ExchangeRate load(){
        Currency currencyIn = new Currency("EUR", "Euro", "€");
        Currency currencyOut = new Currency("USD", "USD Dollar", "$");
        ExchangeRate exchangeRate = new ExchangeRate(currencyIn, currencyOut, 1.2);
        return exchangeRate;
    }
    
}
