package testing.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testing.Meal;
import testing.MealRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MealRepositoryTest {

    private MealRepository mealRepository;
    private Meal meal;

    @BeforeEach
    void setup(){
        mealRepository = new MealRepository();
        meal = new Meal(10, "Pizza");
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {

        //given
        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository(){
        //given
        mealRepository.add(meal);
        //when
        mealRepository.delete(meal);

        //then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByName(){

        //given
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByName("Pizza");

        //then
        assertThat(results.size(), is(1));
    }

    @Test
    void shouldBeAbleToFindMealByPrice(){

        //given
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByPrice(10);

        //then
        assertThat(results.size(), is(1));
    }

}
