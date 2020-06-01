package portaltek.hexa.domain.svc.catalog;

import portaltek.hexa.domain.dto.catalog.Catalog;
import portaltek.hexa.domain.interfaces.Notifier;


class CreateCatalogNotifier implements Notifier<Catalog> {

    private ImportCatalogRepo repo;

    @Override
    public Catalog notify(Catalog catalog) {
        return repo.create(catalog);
    }
}
