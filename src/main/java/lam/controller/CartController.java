package lam.controller;

import lam.model.entity.Cart;
import lam.model.entity.CartDetail;
import lam.model.entity.User;
import lam.model.service.cart.CartServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cartController")
public class CartController {
    CartServiceIMPL cartServiceIMPL = new CartServiceIMPL();

    @GetMapping("/showCart")
    public String showCart(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userlogin");
        int userId = user.getIdUser();
        List<CartDetail> cartDetailList = cartServiceIMPL.showCart(userId);
        float total = cartServiceIMPL.total(cartDetailList);
        model.addAttribute("total", total);
        model.addAttribute("listCart", cartDetailList);
        return "cart";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idCart") int id) {
        cartServiceIMPL.delete(id);
        return "redirect:/cartController/showCart";
    }

    @GetMapping("/quantityUp")
    public String quantityUp(@RequestParam("idUp") int id) {
        cartServiceIMPL.quantityUp(new Cart(id));
        return "redirect:/cartController/showCart";
    }

    @GetMapping("/quantityDown")
    public String quantityDown(@RequestParam("idDown") int id) {
        Cart cart = cartServiceIMPL.findById(id);
        if (cart.getQuantityBuy() <= 1) {
            cartServiceIMPL.delete(id);
        }
        cartServiceIMPL.quantityDown(new Cart(id));
        return "redirect:/cartController/showCart";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("idProduct") int idPro, Model model, HttpSession session) {
        User user = (User) session.getAttribute("userlogin");
        int userId = user.getIdUser();
        Cart cart = cartServiceIMPL.findByIdProAndIdUser(userId, idPro);
        if (cart == null) {
            cartServiceIMPL.save(new Cart(idPro, userId));
        } else {
            cartServiceIMPL.update(cart);
        }
        return "redirect:/productController/show";
    }
}
