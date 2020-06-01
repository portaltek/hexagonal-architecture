package portaltek.hexa.domain.svc.catalog;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.spi.repo.CatalogDtoRepo;
import portaltek.hexa.spi.repo.CompanyDtoRepo;
import portaltek.hexa.spi.repo.FiscalPeriodDtoRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static portaltek.hexa.domain.svc.catalog.ImportCatalogTestUtils.getValidCatalog;
import static portaltek.hexa.domain.svc.catalog.ImportCatalogTestUtils.getValidCmd;

@ExtendWith(MockitoExtension.class)
class ImportCatalogDtoSvcImplUnitTest {

    @Mock
    CompanyDtoRepo companyDtoRepo;
    @Mock
    FiscalPeriodDtoRepo fiscalPeriodDtoRepo;
    @Mock
    CatalogDtoRepo catalogDtoRepo;
    @Mock
    CreateCatalogNotifier notifier;

    @InjectMocks
    ImportCatalogSvcImpl svc;

    @Test
    void givenNewValidCmd_willCreateCatalog() throws HexaException {

        ImportCatalogCmd cmd = getValidCmd(1L, 0L, 5L);
        CatalogDto catalogDto = getValidCatalog(1L, 0L, 5L);

        //GIVEN
        given(catalogDtoRepo.findByCompanyIdAndFiscalPeriodId(any(Long.class), any(Long.class))).willReturn(null);
        given(companyDtoRepo.findById(any(Long.class))).willReturn(catalogDto.companyDto());
        given(fiscalPeriodDtoRepo.findById(any(Long.class))).willReturn(catalogDto.fiscalPeriodDto());

        //WHEN
        CatalogDto catalogDtoOutput = svc.importCatalog(cmd);

        //THEN
        assertNotNull(catalogDtoOutput);
        assertEquals(catalogDto, catalogDtoOutput);
        verify(notifier).notify(catalogDto);


    }


}