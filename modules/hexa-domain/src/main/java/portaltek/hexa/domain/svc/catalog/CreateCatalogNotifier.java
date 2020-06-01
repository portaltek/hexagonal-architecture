package portaltek.hexa.domain.svc.catalog;

import portaltek.hexa.domain.dto.catalog.CatalogDto;
import portaltek.hexa.domain.interfaces.Notifier;


class CreateCatalogNotifier implements Notifier<CatalogDto> {

    private ImportCatalogRepo repo;

    @Override
    public CatalogDto notify(CatalogDto catalogDto) {
        return repo.create(catalogDto);
    }
}
