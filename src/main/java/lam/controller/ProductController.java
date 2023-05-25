package lam.controller;


import lam.model.entity.*;
import lam.model.service.cart.CartServiceIMPL;
import lam.model.service.catalog.CatalogServiceIMPL;
import lam.model.service.comment.CommentServiceIMPL;
import lam.model.service.product.ProductServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

@Controller
@RequestMapping({"/productController", "/"})
public class ProductController {
    CatalogServiceIMPL catalogServiceIMPL = new CatalogServiceIMPL();
    ProductServiceIMPL productServiceIMPL = new ProductServiceIMPL();
    CartServiceIMPL cartServiceIMPL = new CartServiceIMPL();
    CommentServiceIMPL commentServiceIMPL = new CommentServiceIMPL();

    @GetMapping({"/show", "/"})
    public String showAll(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userlogin");
        if (user != null) {
            int userId = user.getIdUser();
            List<CartDetail> cartDetailList = cartServiceIMPL.showCart(userId);
            model.addAttribute("listCart", cartDetailList);
        }
        List<Product> list = productServiceIMPL.findAll();
        List<Product> listPage = productServiceIMPL.findProductByPage(1, 8);
        int pageNumber = (list.size() % 8) == 0 ? (list.size() / 8) : (list.size() / 8 + 1);
        model.addAttribute("list", listPage);
        model.addAttribute("proCata", catalogServiceIMPL.findAll());
        model.addAttribute("pageCount", new Array[pageNumber]);
        return "product";
    }

    @GetMapping("/page/{id}")
    public String page(@PathVariable("id") String id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("userlogin");
        if (user != null) {
            int userId = user.getIdUser();
            List<CartDetail> cartDetailList = cartServiceIMPL.showCart(userId);
            model.addAttribute("listCart", cartDetailList);
        }
        List<Product> list = productServiceIMPL.findAll();
        List<Product> listPage = productServiceIMPL.findProductByPage(Integer.parseInt(id), 8);
        int pageNumber = (list.size() % 8) == 0 ? (list.size() / 8) : (list.size() / 8 + 1);
        model.addAttribute("list", listPage);
        model.addAttribute("proCata", catalogServiceIMPL.findAll());
        model.addAttribute("pageCount", new Array[pageNumber]);
        model.addAttribute("page", Integer.parseInt(id));
        return "product";
    }

    @GetMapping("/showByCatalog")
    public String showByDetail(@RequestParam("idCatalog") int id, Model model) {
        List<Product> list = productServiceIMPL.showByCatalog(id);
        model.addAttribute("listCata", list);
        model.addAttribute("proCata", catalogServiceIMPL.findAll());
        return "productByCatalog";
    }

    @GetMapping("/searchProduct")
    public String searchProduct(@RequestParam("nameProduct") String name, Model model) {
        List<Product> list = productServiceIMPL.searchProduct(name);
        model.addAttribute("proCata", catalogServiceIMPL.findAll());
        model.addAttribute("list", list);
        return "product";
    }

    @GetMapping("/showProductDetail")
    public String showProductDetail(@RequestParam("idProduct") int id, Model model) {
        Product product = productServiceIMPL.findById(id);
        List<Comment> commentList = commentServiceIMPL.showAllToProduct(id);
        model.addAttribute("comment", commentList);
        model.addAttribute("list", product);
        model.addAttribute("proCata", catalogServiceIMPL.findAll());
        return "productDetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idProduct") int id) {
        productServiceIMPL.delete(id);
        return "redirect:/adminController/showProduct";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("catalog", catalogServiceIMPL.findAll());
        return "admin/product/createProduct";
    }

    @PostMapping("/add")
    public String add(@RequestParam("image") MultipartFile image,
                      @RequestParam("name") String name,
                      @RequestParam("title") String title,
                      @RequestParam("quantity") int quantity,
                      @RequestParam("price") float price,
                      @RequestParam("catalog") int catalog,
                      Model model) throws IOException {
        String uploadPath = "D:\\MD4\\MD4_Project\\src\\main\\webapp\\aset\\image\\";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = image.getOriginalFilename();
        FileCopyUtils.copy(image.getBytes(), new File(uploadPath + fileName));
        Catalog cata = catalogServiceIMPL.findById(catalog);
        productServiceIMPL.save(new Product(name, fileName, title, quantity, price, cata));
        return "redirect:/adminController/showProduct";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("idProduct") int id, Model model) {
        Product productEdit = productServiceIMPL.findById(id);
        model.addAttribute("product", productEdit);
        model.addAttribute("catalog", catalogServiceIMPL.findAll());
        return "admin/product/editProduct";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id,
                         @RequestParam("oldImage") String oleImage,
                         @RequestParam("image") MultipartFile image,
                         @RequestParam("name") String name,
                         @RequestParam("title") String title,
                         @RequestParam("quantity") int quantity,
                         @RequestParam("price") float price,
                         @RequestParam("status") boolean status,
                         @RequestParam("catalog") int catalog, Model model) throws IOException {
        String uploadPath = "D:\\MD4\\MD4_Project\\src\\main\\webapp\\aset\\image\\";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = image.getOriginalFilename();
        if (fileName.length() == 0) {
            fileName = oleImage;
        } else {
            FileCopyUtils.copy(image.getBytes(), new File(uploadPath + fileName));
        }
        Catalog cata = catalogServiceIMPL.findById(catalog);
        Product product = new Product(id, name, fileName, title, quantity, price, status, cata);
        productServiceIMPL.update(product);
        return "redirect:/adminController/showProduct";
    }
}
