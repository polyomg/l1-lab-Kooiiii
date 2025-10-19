package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rect")
public class RectController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/form")
    public String form() {
        return "rect/form";
    }

    @RequestMapping("/calculate")
    public String calculate(Model model) {
        try {
            double width = Double.parseDouble(request.getParameter("width"));
            double height = Double.parseDouble(request.getParameter("height"));

            double area = width * height;
            double perimeter = 2 * (width + height);

            model.addAttribute("width", width);
            model.addAttribute("height", height);
            model.addAttribute("area", area);
            model.addAttribute("perimeter", perimeter);

        } catch (Exception e) {
            model.addAttribute("có lỗi", "Vui lòng nhập số hợp lệ!");
        }
        return "rect/form";
    }
}
