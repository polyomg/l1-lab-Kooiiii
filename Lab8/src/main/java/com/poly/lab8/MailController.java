package Lab8.controller;

import Lab8.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    // Form nhập mail
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("mail", new MailService.Mail());
        return "mail/form";
    }

    // Gửi trực tiếp
    @PostMapping("/send")
    public String send(@ModelAttribute("mail") MailService.Mail mail, Model model) {
        mailService.send(mail);
        model.addAttribute("message", "Mail đã được gửi trực tiếp thành công!");
        return "mail/form";
    }

    // Đưa vào hàng đợi
    @PostMapping("/queue")
    public String queue(@ModelAttribute("mail") MailService.Mail mail, Model model) {
        mailService.push(mail);
        model.addAttribute("message", "Mail đã được xếp vào hàng đợi!");
        return "mail/form";
    }
}

