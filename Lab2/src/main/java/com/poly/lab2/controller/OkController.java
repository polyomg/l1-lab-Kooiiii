package Lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    @GetMapping("/ok")
    public String showForm() {
        return "ok"; 
    }


    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("message", "Phương thức m1() được gọi");
        return "ok";
    }

    
    @GetMapping(value = "/ok", params = "!x")
    public String m2(Model model) {
        model.addAttribute("message", "Phương thức m2() được gọi");
        return "ok";
    }

    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("message", "Phương thức m3() được gọi");
        return "ok";
    }
}
	