package testing.account;

import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class AccountServiceTest {

    @Test
    void getAllActiveAccounts() {

        //given
        List<Account> accounts = prepareAccountData();
        AccountRepository accountRepositoryMock = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepositoryMock);
        //when(accountRepositoryMock.getAllAccounts()).thenReturn(accounts);
        given(accountRepositoryMock.getAllAccounts()).willReturn(accounts);

        //when
        List<Account> accountList = accountService.getAllActiveAccounts();

        //then
        assertThat(accountList, hasSize(2));

    }

    @Test
    void getAllNoActiveAccounts() {

        //given
        AccountRepository accountRepositoryMock = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepositoryMock);
        //when(accountRepositoryMock.getAllAccounts()).thenReturn(accounts);
        given(accountRepositoryMock.getAllAccounts()).willReturn(Collections.emptyList());

        //when
        List<Account> accountList = accountService.getAllActiveAccounts();

        //then
        assertThat(accountList, hasSize(0));

    }

    private List<Account> prepareAccountData() {
        Address address1 = new Address("Kwiatowa", "33/5");
        Account account1 = new Account(address1);

        Account account2 = new Account();

        Address address2 = new Address("Piekarska", "1/18");
        Account account3 = new Account(address2);

        return Arrays.asList(account1, account2, account3);
    }

    @Test
    void getAccountsByName() {

        //given
        AccountRepository accountRepositoryMock = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepositoryMock);
        //when(accountRepositoryMock.getAllAccounts()).thenReturn(accounts);
        given(accountRepositoryMock.getByName("dawid")).willReturn(Collections.singletonList("nowak"));

        //when
        List<String> accountNames = accountService.findByName("dawid");

        //then
        assertThat(accountNames, contains("nowak"));

    }

}
