package lam.controller;

import lam.model.entity.Catalog;
import lam.model.service.catalog.CatalogServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("catalogController")
public class CatalogController {
    CatalogServiceIMPL catalogServiceIMPL=new CatalogServiceIMPL();
    @GetMapping("/show")
    public String showAll(Model model){
        List<Catalog> list = catalogServiceIMPL.findAll();
        model.addAttribute("list",list);
        return "admin/product/productManager";
    }
}
