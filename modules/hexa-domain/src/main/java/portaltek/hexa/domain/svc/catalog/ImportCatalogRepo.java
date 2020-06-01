package portaltek.hexa.domain.svc.catalog;

import portaltek.hexa.domain.dto.catalog.Catalog;


public interface ImportCatalogRepo {
    Catalog create(Catalog catalog);
    Catalog update(Catalog catalog);
}
