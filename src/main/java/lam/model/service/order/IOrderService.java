package lam.model.service.order;

import lam.model.entity.Order;
import lam.model.entity.OrderDetail;
import lam.model.entity.OrderItem;
import lam.model.service.IService;

import java.util.List;

public interface IOrderService extends IService<Order> {
    Order findByIdToUserLogin(int id);
    List<OrderItem> showOrder();
    List<OrderItem> showOrderToAccount(int id);
    List<OrderItem> showOrderItem(int id);
    List<OrderItem> showOrderToUser(int id);
    boolean checkValidatePhone(String phone);

    boolean saveOrderDetail(OrderDetail orderDetail);

}
