package lam.model.service.cart;

import lam.model.entity.Cart;
import lam.model.entity.CartDetail;
import lam.model.service.IService;

import java.util.List;

public interface ICartService extends IService<Cart> {
    List<CartDetail> showCart(int userLogin);
    Cart findByIdProAndIdUser(int userId,int proId);
    Cart findByIdUser(int userId);
    boolean changeStatus(int id);
    boolean quantityUp(Cart cart);
    boolean quantityDown(Cart cart);
    float total(List<CartDetail> cartDetailList);

}
