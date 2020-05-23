package portaltek.hexa.domain.svc.catalog;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.dto.catalog.Account;
import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.dto.catalog.Company;
import portaltek.hexa.domain.dto.catalog.FiscalPeriod;
import portaltek.hexa.spi.repo.CatalogRepo;
import portaltek.hexa.spi.repo.AccountRepo;
import portaltek.hexa.spi.repo.CompanyRepo;
import portaltek.hexa.spi.repo.FiscalPeriodRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static portaltek.hexa.domain.svc.catalog.ImportCatalogTestUtils.*;

@ExtendWith(MockitoExtension.class)
class ImportCatalogSvcImplTest {

    @Mock
    CompanyRepo companyRepo;
    @Mock
    FiscalPeriodRepo fiscalPeriodRepo;
    @Mock
    CatalogRepo catalogRepo;
    @Mock
    ImportCatalogValidator validator;
    @Mock
    ImportCatalogNotifier notifier;

    @InjectMocks
    ImportCatalogSvcImpl svc;

    @BeforeEach
    void setUp() {
    }


    @Test
    void givenNewValidCmd_willCreateCatalog() throws HexaException {

        ImportCatalogCmd cmd = getValidCmd(1L, 0L, 5L);
        Catalog catalog = getValidCatalog(1L, 0L, 5L);

        //GIVEN
        given(catalogRepo.findByCompanyIdAndFiscalPeriodId(any(Long.class), any(Long.class))).willReturn(null);
        given(companyRepo.findById(any(Long.class))).willReturn(catalog.company());
        given(fiscalPeriodRepo.findById(any(Long.class))).willReturn(catalog.fiscalPeriod());

        //WHEN
        Catalog catalogOutput = svc.doImport(cmd);

        //THEN
        assertNotNull(catalogOutput);
        assertEquals(catalog, catalogOutput);
        verify(notifier).notify(catalog);
    }


}