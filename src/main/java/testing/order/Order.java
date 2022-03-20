package testing.order;

import lombok.Getter;
import testing.Meal;

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

    void cancel(){
        this.meals.clear();
    }

}
