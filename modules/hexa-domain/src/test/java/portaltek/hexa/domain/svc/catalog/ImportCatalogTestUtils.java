package portaltek.hexa.domain.svc.catalog;


import portaltek.hexa.domain.dto.catalog.AccountDto;
import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.domain.dto.catalog.CompanyDto;
import portaltek.hexa.domain.dto.catalog.FiscalPeriodDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.time.LocalDateTime.now;


class ImportCatalogTestUtils {


    static AccountDto getValidAccount(Long id) {
        return AccountDto.builder()
                .id(id)
                .name("AccountNames" + id)
                .code("AccountCode" + id)
                .description("AccountDescription" + id)
                .build();
    }

    static List<AccountDto> getValidAccounts(int id) {

        return LongStream.range(0, id)
                .mapToObj(i -> getValidAccount(i))
                .collect(Collectors.toList());

    }

    static CompanyDto getValidCompany(Long id) {
        return CompanyDto.builder()
                .id(id)
                .code("CompanyCode" + id)
                .name("CompanyName" + id)
                .description("CompanyDescription" + id)
                .build();
    }

    static FiscalPeriodDto getValidFiscalPeriod(Long id) {
        LocalDateTime start = now().truncatedTo(ChronoUnit.DAYS);
        LocalDateTime end = start.plusYears(1);
        return FiscalPeriodDto.builder()
                .id(id)
                .name("FiscalPeriodName"+id)
                .start(start)
                .end(end)
                .build();
    }

    static CatalogDto getValidCatalog(Long companyId,
                                      Long fiscalYearId,
                                      Long accountNumber) {

        CompanyDto companyDto = getValidCompany(companyId);
        FiscalPeriodDto fiscalPeriodDto = getValidFiscalPeriod(fiscalYearId);
        Collection<AccountDto> accountDtos = getValidAccounts(accountNumber.intValue());

        return CatalogDto.builder()
                .companyDto(companyDto)
                .fiscalPeriodDto(fiscalPeriodDto)
                .accountDtos(accountDtos)
                .build();
    }

    static ImportCatalogCmd getValidCmd(Long companyId,
                                   Long fiscalYearId,
                                   Long accountNumber) {

        List<AccountDto> accountDtos = getValidAccounts(accountNumber.intValue());
        try{
            return new ImportCatalogCmd(companyId, fiscalYearId, accountDtos);
        } catch (Exception e){
            return null;
        }
    }

}