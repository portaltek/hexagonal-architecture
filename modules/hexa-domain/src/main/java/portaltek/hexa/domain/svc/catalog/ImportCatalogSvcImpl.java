package portaltek.hexa.domain.svc.catalog;

import lombok.AllArgsConstructor;
import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.domain.dto.catalog.CompanyDto;
import portaltek.hexa.domain.dto.catalog.FiscalPeriodDto;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.spi.repo.CatalogDtoRepo;
import portaltek.hexa.spi.repo.CompanyDtoRepo;
import portaltek.hexa.spi.repo.FiscalPeriodDtoRepo;

@AllArgsConstructor
class ImportCatalogSvcImpl implements ImportCatalogSvc {

    CompanyDtoRepo companyDtoRepo;
    FiscalPeriodDtoRepo fiscalPeriodDtoRepo;
    CatalogDtoRepo catalogDtoRepo;

    CreateCatalogNotifier notifier;



    public CatalogDto importCatalog(ImportCatalogCmd cmd) throws HexaException {

        CatalogDto oldCatalogDto = catalogDtoRepo
                .findByCompanyIdAndFiscalPeriodId(cmd.companyId(), cmd.fiscalPeriodId());
        if (oldCatalogDto == null){
            return createCatalog(cmd);
        }
        //updateAccountCatalog
        //Persist
        return null;
    }

    private CatalogDto createCatalog(ImportCatalogCmd cmd) throws HexaException {

        //QUERY APIs
        CompanyDto companyDto = companyDtoRepo.findById(cmd.companyId());
        FiscalPeriodDto fiscalPeriodDto = fiscalPeriodDtoRepo.findById(cmd.fiscalPeriodId());

        //BUILD DTO
        CatalogDto catalogDto = new CatalogDto()
                .companyDto(companyDto)
                .fiscalPeriodDto(fiscalPeriodDto)
                .accountDtos(cmd.accountDtos());



        //validator.validate(catalog);

        //Notify SPIs
        notifier.notify(catalogDto);

        return catalogDto;

    }



}
