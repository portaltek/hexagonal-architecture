package portaltek.hexa.domain.svc.catalog;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.spi.repo.CatalogRepo;
import portaltek.hexa.spi.repo.CompanyRepo;
import portaltek.hexa.spi.repo.FiscalPeriodRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static portaltek.hexa.domain.svc.catalog.ImportCatalogTestUtils.getValidCatalog;
import static portaltek.hexa.domain.svc.catalog.ImportCatalogTestUtils.getValidCmd;

@ExtendWith(MockitoExtension.class)
class ImportCatalogSvcImplUnitTest {

    @Mock
    CompanyRepo companyRepo;
    @Mock
    FiscalPeriodRepo fiscalPeriodRepo;
    @Mock
    CatalogRepo catalogRepo;
    @Mock
    CreateCatalogNotifier notifier;

    @InjectMocks
    ImportCatalogSvcImpl svc;

    @Test
    void givenNewValidCmd_willCreateCatalog() throws HexaException {

        ImportCatalogCmd cmd = getValidCmd(1L, 0L, 5L);
        Catalog catalog = getValidCatalog(1L, 0L, 5L);

        //GIVEN
        given(catalogRepo.findByCompanyIdAndFiscalPeriodId(any(Long.class), any(Long.class))).willReturn(null);
        given(companyRepo.findById(any(Long.class))).willReturn(catalog.company());
        given(fiscalPeriodRepo.findById(any(Long.class))).willReturn(catalog.fiscalPeriod());

        //WHEN
        Catalog catalogOutput = svc.importCatalog(cmd);

        //THEN
        assertNotNull(catalogOutput);
        assertEquals(catalog, catalogOutput);
        verify(notifier).notify(catalog);


    }


}