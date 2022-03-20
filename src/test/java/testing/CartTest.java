package testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

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
}