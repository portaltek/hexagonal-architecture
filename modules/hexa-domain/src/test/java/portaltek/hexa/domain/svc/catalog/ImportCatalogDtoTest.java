package portaltek.hexa.domain.svc.catalog;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import portaltek.hexa.domain.dto.catalog.Account;
import portaltek.hexa.domain.HexaException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ImportCatalogDtoTest {

    @BeforeEach
    void setUp() {
    }

    private Account getAccount(Long id) {
        return Account.builder()
                .id(1L)
                .name("n")
                .code("c")
                .description("d")
                .build();
    }


    @Test
    public void givenInvalidAccounts_whenDtoCreation_thenThrowException() throws HexaException {
        Set<Account> accounts = Stream.of(getAccount(1L), getAccount(2L))
                .map(i-> i.description(""))
                .collect(Collectors.toSet());

        HexaException exception = assertThrows(HexaException.class,
                () -> {
                    new ImportCatalogCmd(1L, 1L, accounts);
                });

        System.out.println(exception.errors());
    }

    @Test
    public void givenInvalidCompany_whenDtoCreation_thenThrowException() {

        Set<Account> accounts = Stream.of(getAccount(1L)).collect(Collectors.toSet());
        HexaException exception = assertThrows(HexaException.class,
                () -> {
                    new ImportCatalogCmd(null, 1L, accounts);
                });

        System.out.println(exception);
    }
}