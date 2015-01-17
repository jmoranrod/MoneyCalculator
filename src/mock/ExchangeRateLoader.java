package mock;

import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoader implements persistence.ExchangeRateLoader {
    
    @Override
    public ExchangeRate load(Currency in, Currency out){
        return new ExchangeRate(in, out, computeRates(in,out));
    }

    private double computeRates(Currency in, Currency out) {
        return Math.random();
    }
    
}
