package portaltek.hexa.domain.svc.catalog;

import portaltek.hexa.domain.dto.catalog.CatalogDto;


public interface ImportCatalogRepo {
    CatalogDto create(CatalogDto catalogDto);
    CatalogDto update(CatalogDto catalogDto);
}
