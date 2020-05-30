package portaltek.hexa.domain.svc.catalog;

import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.HexaException;
import portaltek.hexa.domain.interfaces.Service;


public interface ImportCatalogSvc extends Service {
    Catalog importCatalog(ImportCatalogCmd cmd) throws HexaException;
}
