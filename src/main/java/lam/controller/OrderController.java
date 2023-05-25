package lam.controller;

import lam.model.entity.*;
import lam.model.service.cart.CartServiceIMPL;
import lam.model.service.order.OrderServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/orderController")
public class OrderController {
    OrderServiceIMPL orderServiceIMPL = new OrderServiceIMPL();
    CartServiceIMPL cartServiceIMPL = new CartServiceIMPL();

    @GetMapping("/showOrderToUser")
    public String showOrderToUser(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userlogin");
        int userId = user.getIdUser();
        List<OrderItem> orderItemList = orderServiceIMPL.showOrderToAccount(userId);
        model.addAttribute("listOrder", orderItemList);
        return "order";
    }
    @GetMapping("/showAllOrder")
    public String showAllOrder(@RequestParam("idOrder") int idOrder, Model model) {
        Order order = orderServiceIMPL.findById(idOrder);
        List<OrderItem> orderItemList = orderServiceIMPL.showOrderItem(idOrder);
        model.addAttribute("order",order);
        model.addAttribute("listOrder", orderItemList);
        return "admin/order/showOrder";
    }
    @GetMapping("/showAll")
    public String showAll(@RequestParam("idOrder") int idOrder, Model model) {
        Order order = orderServiceIMPL.findById(idOrder);
        List<OrderItem> orderItemList = orderServiceIMPL.showOrderItem(idOrder);
        model.addAttribute("order",order);
        model.addAttribute("listOrder", orderItemList);
        return "showOrder";
    }

    @GetMapping("/showToAdmin")
    public String showOrderToAdmin(Model model) {
        List<OrderItem> orderItemList = orderServiceIMPL.showOrder();
        model.addAttribute("listOrder", orderItemList);
        return "admin/order/orderManager";
    }

    @PostMapping("/createOrder")
    public String createOrder(@RequestParam("nameReceiver") String nameReceiver,
                              @RequestParam("phone") String phone,
                              @RequestParam("address") String address,
                              Model model, HttpSession session
    ) {
        User user = (User) session.getAttribute("userlogin");
        int userId = user.getIdUser();
        List<CartDetail> cartDetailList = cartServiceIMPL.showCart(userId);
        float total = cartServiceIMPL.total(cartDetailList);
        int idOder = orderServiceIMPL.idAutoIncrementOder();
        Order order = new Order(idOder, nameReceiver, phone, address, total);
        orderServiceIMPL.save(order);
        for (CartDetail cartDetail : cartDetailList) {
            orderServiceIMPL.saveOrderDetail(new OrderDetail(idOder, cartDetail.getIdCartDetail()));
        }
        return "redirect:/orderController/showOrderToUser";
    }
    @GetMapping("/changeStatusOrder")
    public String changeStatusOrder(@RequestParam("idOrder") int id){
        Order order = new Order(id);
        orderServiceIMPL.update(order);
        return "redirect:/orderController/showToAdmin";
    }
}
