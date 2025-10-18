package Lab5.Controller;

import Lab5.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("ShoppingCartController")
@RequestMapping("/cart") 
public class ShoppingCartController {

    @Autowired
    ShoppingCartService cart;

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        return "cart/index";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cart.add(id);
        return "redirect:/cart/view";
    }

    @GetMapping("/remove/{id}") 
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,
                         @RequestParam("qty") Integer qty) {
        cart.update(id, qty);
        return "redirect:/cart/view";
    }

    @GetMapping("/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }
}
