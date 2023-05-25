package lam.model.service.catalog;

import lam.model.entity.Catalog;
import lam.model.service.IService;

public interface ICatalogService extends IService<Catalog> {
    Catalog findByName(String name);
}
