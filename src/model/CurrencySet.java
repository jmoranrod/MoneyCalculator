package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CurrencySet implements Iterable<Currency> {
    private final Map<String, Currency> map;
    
    public CurrencySet(HashMap<String, Currency> map) {
        this.map = map;
    }
    
    public Currency get(String name){
        return map.get(name);
    }
    
    public void add(Currency currency){
        if (!map.containsKey(currency.getCode()))
            map.put(currency.getCode(), currency);     
    }
    
    @Override
    public Iterator<Currency> iterator() {
        return new Iterator<Currency>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Currency next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
}
