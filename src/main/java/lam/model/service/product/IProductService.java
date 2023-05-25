package lam.model.service.product;


import lam.model.entity.Product;
import lam.model.service.IService;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> searchProduct(String nameSearch);
    List<Product> showByCatalog(int id);
    List<Product> findProductByPage(int page,int count);

}
