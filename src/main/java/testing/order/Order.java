package testing.order;

import lombok.Getter;
import lombok.ToString;
import testing.Meal;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Order {

    private OrderStatus orderStatus;
    private List<Meal> meals = new ArrayList<>();

    public void changeOrderStatus(OrderStatus orderStatus){
        this.orderStatus=orderStatus;
    }

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
