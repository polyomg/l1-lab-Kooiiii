package Lab2.controller34;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController4 {

    private List<Product> itemList = new ArrayList<>(Arrays.asList(
            new Product("A", 1.0),
            new Product("B", 12.0)
    ));

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product("iPhone 30", 5000.0);

        model.addAttribute("p1", p);
        model.addAttribute("p2", null);
        model.addAttribute("items", itemList); 
        return "Product/form";
    }

    // POST /product/save
    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        itemList.add(p);
        model.addAttribute("p2", p);
        model.addAttribute("p1", new Product("iPhone 30", 5000.0));
        model.addAttribute("items", itemList); 
        return "Product/form";
    }
}