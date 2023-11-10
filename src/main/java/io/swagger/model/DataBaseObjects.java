package io.swagger.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class DataBaseObjects {
    public class RentalProperty {
        private String address;
        private Integer monthlyRent;
        private BigDecimal price;

        public RentalProperty(String address, Integer monthlyRent, BigDecimal price) {
            this.address = address;
            this.monthlyRent = monthlyRent;
            this.price = price;
        }

        public String getAddress() {
            return address;
        }


        public int getMonthlyRent() {
            return monthlyRent;
        }

        public BigDecimal getPrice(){ return price; }

        public void put(BigDecimal price, Integer monthlyrent){
            this.price = price;
            this.monthlyRent = monthlyrent;
        }

    }

    public volatile HashMap<String, RentalProperty> properties = new HashMap<>();
    public void addProperty(String address, Integer monthlyRent, BigDecimal price) {
        properties.put(address, new RentalProperty(address, monthlyRent, price));
    }

    public RentalProperty getObj(String address){
        return properties.get(address);
    }

    public void remove(String address){
        properties.remove(address);
    }

    public void put_obj(String address, BigDecimal price, Integer monthlyrent){
        RentalProperty rp = properties.get(address);
        if (rp != null)
            rp.put(price, monthlyrent);
        else
            properties.put(address, new RentalProperty(address, monthlyrent, price));
    }

    public Set<Map.Entry<String, RentalProperty>> getObjects(){
        return properties.entrySet();
    }
}
