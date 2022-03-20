package testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testing.order.Order;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Visible name of test class")
class CartTest {

    @Disabled
    @Test
    void simulateLargeOrder() {

        //given
        Cart cart = new Cart();

        //then + when
        assertTimeout(Duration.ofMillis(10), ()-> cart.simulateLargeOrder());
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart(){
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty()))
        ));
        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty()))
        ));

        assertAll(
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), hasSize(1))
        );

    }

}