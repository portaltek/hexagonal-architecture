package portaltek.hexa.domain.svc.catalog;

import lombok.AllArgsConstructor;
import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.dto.catalog.Company;
import portaltek.hexa.domain.dto.catalog.FiscalPeriod;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.spi.repo.CatalogRepo;
import portaltek.hexa.spi.repo.CompanyRepo;
import portaltek.hexa.spi.repo.FiscalPeriodRepo;

@AllArgsConstructor
class ImportCatalogSvcImpl implements ImportCatalogSvc {

    CompanyRepo companyRepo;
    FiscalPeriodRepo fiscalPeriodRepo;
    CatalogRepo catalogRepo;

    ImportCatalogValidator validator;
    ImportCatalogNotifier notifier;



    public Catalog doImport(ImportCatalogCmd cmd) throws HexaException {

        Catalog oldCatalog = catalogRepo
                .findByCompanyIdAndFiscalPeriodId(cmd.companyId(), cmd.fiscalPeriodId());
        if (oldCatalog == null){
            return createCatalog(cmd);
        }
        //updateAccountCatalog
        //Persist
        return null;
    }

    private Catalog createCatalog(ImportCatalogCmd cmd) throws HexaException {

        Company company = companyRepo.findById(cmd.companyId());
        FiscalPeriod fiscalPeriod = fiscalPeriodRepo.findById(cmd.fiscalPeriodId());

        Catalog catalog = Catalog.builder()
                .company(company)
                .fiscalPeriod(fiscalPeriod)
                .accountList(cmd.accounts())
                .build();



        //validator.validate(catalog);
        notifier.notify(catalog);

        return catalog;

    }



}
