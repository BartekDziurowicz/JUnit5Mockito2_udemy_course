package testing;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Order {

    @Getter
    private List<Meal> meals = new ArrayList<>();

    public void addMealToOrder(Meal meal){
        this.meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal){
        this.meals.remove(meal);
    }

}
