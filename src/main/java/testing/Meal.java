package testing;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Meal {

    @Getter
    private int price;
    private String name;

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getDiscountedPrice(int discount){
        return this.price-discount;
    }
}
