package portaltek.hexa.domain.svc.catalog;

import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.interfaces.Service;


public interface ImportCatalogSvc extends Service {
    CatalogDto importCatalog(ImportCatalogCmd cmd) throws HexaException;
}
