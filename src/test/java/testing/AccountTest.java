package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation(){
        //given + when
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
    }

    @Test
    void accountShouldBeActiveAfterActivation(){
        //given
        Account newAccount = new Account();
        //when
        newAccount.active();
        //then
        assertTrue(newAccount.isActive());
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given + when
        Address address = new Address("Katowicka", "69s");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        //then
        assertNotNull(account.getDefaultDeliveryAddress());
    }

}
