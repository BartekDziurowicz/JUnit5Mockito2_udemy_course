package testing;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Meal {

    private int price;
    private int quantity;
    private String name;

    public Meal(){}

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getDiscountedPrice(int discount){
        if(discount>this.price){
            throw new IllegalArgumentException("Discount cannot be higher than the proce");
        }
        return this.price-discount;
    }

    public int sumPrice(){
        return getPrice() * getQuantity();
    }

}
