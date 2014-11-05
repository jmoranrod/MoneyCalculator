package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CurrencySet implements Iterable<Currency> {
    private final Map<String, Currency> map;
    
    public CurrencySet() {
        this.map = new HashMap<>();
    }
    
    public Currency get(String name){
        return map.get(name);
    }
    
    public void add(Currency currency){
        if (map.containsKey(currency.getCode())) return;
        map.put(currency.getCode(), currency);     
    }
    
    @Override
    public Iterator<Currency> iterator() {
        return map.values().iterator();
    }
    
}
