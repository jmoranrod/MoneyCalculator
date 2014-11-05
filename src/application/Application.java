package application;

import Persistence.CurrencySetLoader;
import control.ExchangeOperation;
import model.CurrencySet;

public class Application {
    
    CurrencySet currencySet = new CurrencySetLoader().load();
    //ExchangeOperation(currencySet).execute();
}
