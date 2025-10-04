package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/form")
    public String form() {
        return "login/form";
    }

    @RequestMapping("/check")
    public String login(Model model) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if ("poly".equals(user) && "123".equals(pass)) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Bạn đã sai rồi!");
        }
        return "login/form";
    }
}
