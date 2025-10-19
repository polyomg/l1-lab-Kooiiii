package Lab5.Controller;

import Lab5.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("CartController")
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    ShoppingCartService cart;

    @GetMapping("/add/{id}")
    @ResponseBody
    public Object add(@PathVariable("id") Integer id) {
        return cart.add(id);
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "Removed " + id;
    }

    @GetMapping("/update/{id}/{qty}")
    @ResponseBody
    public Object update(@PathVariable("id") Integer id, @PathVariable("qty") int qty) {
        return cart.update(id, qty);
    }

    @GetMapping("/clear")
    @ResponseBody
    public String clear() {
        cart.clear();
        return "Cart cleared";
    }

    @GetMapping("/items")
    @ResponseBody
    public Object getItems() {
        return cart.getItems();
    }

    @GetMapping("/count")
    @ResponseBody
    public int getCount() {
        return cart.getCount();
    }

    @GetMapping("/amount")
    @ResponseBody
    public double getAmount() {
        return cart.getAmount();
    }
}
