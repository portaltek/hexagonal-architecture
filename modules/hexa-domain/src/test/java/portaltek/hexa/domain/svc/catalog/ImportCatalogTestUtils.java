package portaltek.hexa.domain.svc.catalog;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.dto.catalog.Account;
import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.dto.catalog.Company;
import portaltek.hexa.domain.dto.catalog.FiscalPeriod;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ImportCatalogTestUtils {


    static Account getValidAccount(Long id) {
        return Account.builder()
                .id(id)
                .name("AccountName" + id)
                .code("AccountCode" + id)
                .description("AccountDescription" + id)
                .build();
    }

    static Set<Account> getValidAccounts(Long id) {

        return LongStream.range(0, id)
                .mapToObj(i -> getValidAccount(i))
                .collect(Collectors.toSet());

    }

    static Company getValidCompany(Long id) {
        return Company.builder()
                .id(id)
                .code("CompanyCode" + id)
                .name("CompanyName" + id)
                .description("CompanyDescription" + id)
                .build();
    }

    static FiscalPeriod getValidFiscalPeriod(Long id) {
        LocalDateTime start = now().truncatedTo(ChronoUnit.DAYS);
        LocalDateTime end = start.plusYears(1);
        return FiscalPeriod.builder()
                .id(id)
                .name("FiscalPeriodName"+id)
                .start(start)
                .end(end)
                .build();
    }

    static Catalog getValidCatalog(Long companyId,
                                   Long fiscalYearId,
                                   Long accountNumber) {

        Company company = getValidCompany(companyId);
        FiscalPeriod fiscalPeriod = getValidFiscalPeriod(fiscalYearId);
        Set<Account> accounts = getValidAccounts(accountNumber);

        return Catalog.builder()
                .company(company)
                .fiscalPeriod(fiscalPeriod)
                .accountList(accounts)
                .build();
    }

    static ImportCatalogCmd getValidCmd(Long companyId,
                                   Long fiscalYearId,
                                   Long accountNumber) {

        Set<Account> accounts = getValidAccounts(accountNumber);
        try{
            return new ImportCatalogCmd(companyId, fiscalYearId, accounts);
        } catch (Exception e){
            return null;
        }
    }

}