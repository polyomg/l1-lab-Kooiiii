package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {
    @RequestMapping("/poly/hello")
    public String sayHello(Model model) {
        model.addAttribute("subject", "TS01044 - Nguyễn Đặng Anh Khôi");
        return "demo/hello"; 
    }
}
