package lam.controller;

import lam.model.entity.Catalog;
import lam.model.entity.Product;
import lam.model.service.catalog.CatalogServiceIMPL;
import lam.model.service.product.ProductServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/adminController")
public class AdminController {
    ProductServiceIMPL productServiceIMPL = new ProductServiceIMPL();
    CatalogServiceIMPL catalogServiceIMPL = new CatalogServiceIMPL();

    //***********************************PRODUCT**************************

    @GetMapping("/homeAdmin")
    public String showHomeAdmin() {
        return "admin/Admin";
    }

    @GetMapping("/showProduct")
    public String showAllToAdmin(Model model) {
        List<Product> list = productServiceIMPL.findAll();
        model.addAttribute("list", list);
        return "admin/product/productManager";
    }
//********************************CATALOG**********************************


    @GetMapping("/showCatalog")
    public String showAll(Model model) {
        List<Catalog> list = catalogServiceIMPL.findAll();
        model.addAttribute("list", list);
        return "admin/catalog/catalogManager";
    }
    @GetMapping("/deleteCatalog")
    public String delete(@RequestParam("idCatalog") int id){
        catalogServiceIMPL.delete(id);
        return "redirect:/adminController/showCatalog";
    }

    @GetMapping("/createCatalog")
    public String createCatalog() {
        return "admin/catalog/createCatalog";
    }

    @PostMapping("/addCatalog")
    public String add(Model model, @RequestParam("nameCatalog") String nameCatalog) {
        catalogServiceIMPL.save(new Catalog(nameCatalog));
        return "redirect:/adminController/showCatalog";
    }
    @GetMapping("/editCatalog")
    public ModelAndView editCatalog(@RequestParam("idCatalog") int id){
        Catalog editCatalog =catalogServiceIMPL.findById(id);
        ModelAndView modelAndView=new ModelAndView("admin/catalog/editCatalog");
        modelAndView.addObject("catalog",editCatalog);
        return modelAndView;
    }
    @PostMapping("/updateCatalog")
    public String updateCatalog(@ModelAttribute("catalog") Catalog catalog, Model model){
        catalogServiceIMPL.update(catalog);
        return "redirect:/adminController/showCatalog";

    }
}
