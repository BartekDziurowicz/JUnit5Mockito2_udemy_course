package testing.account;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation(){
        //given + when
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
        //then cd...     hamcrest matchery
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
    }

    @Test
    void accountShouldBeActiveAfterActivation(){
        //given
        Account newAccount = new Account();
        //when
        newAccount.active();
        //then
        assertTrue(newAccount.isActive());
        //then cd...     hamcrest matchery
        assertThat(newAccount.isActive(), equalTo(true));
        assertThat(newAccount.isActive(), is(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);
        //then cd...     hamcrest matchery
        assertThat(account.getDefaultDeliveryAddress(), equalTo(null));
        assertThat(account.getDefaultDeliveryAddress(), nullValue());
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given + when
        Address address = new Address("Katowicka", "69s");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        //then
        assertNotNull(account.getDefaultDeliveryAddress());
        //then cd...     hamcrest matchery
        assertThat(account.getDefaultDeliveryAddress(), notNullValue());
    }

    @RepeatedTest(25)
    void newAccountWithinNotNUllAddressShouldBeActive(){
        //given
        Address address = new Address("Katowicka", "5a");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }

}
