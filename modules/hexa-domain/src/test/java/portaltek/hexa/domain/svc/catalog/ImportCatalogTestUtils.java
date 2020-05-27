package portaltek.hexa.domain.svc.catalog;


import portaltek.hexa.domain.dto.catalog.Account;
import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.dto.catalog.Company;
import portaltek.hexa.domain.dto.catalog.FiscalPeriod;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.time.LocalDateTime.now;


class ImportCatalogTestUtils {


    static Account getValidAccount(Long id) {
        return Account.builder()
                .id(id)
                .name("AccountNames" + id)
                .code("AccountCode" + id)
                .description("AccountDescription" + id)
                .build();
    }

    static List<Account> getValidAccounts(int id) {

        return LongStream.range(0, id)
                .mapToObj(i -> getValidAccount(i))
                .collect(Collectors.toList());

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
        Collection<Account> accounts = getValidAccounts(accountNumber.intValue());

        return Catalog.builder()
                .company(company)
                .fiscalPeriod(fiscalPeriod)
                .accounts(accounts)
                .build();
    }

    static ImportCatalogCmd getValidCmd(Long companyId,
                                   Long fiscalYearId,
                                   Long accountNumber) {

        List<Account> accounts = getValidAccounts(accountNumber.intValue());
        try{
            return new ImportCatalogCmd(companyId, fiscalYearId, accounts);
        } catch (Exception e){
            return null;
        }
    }

}