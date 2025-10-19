package Lab5.Bai123;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

   
    @GetMapping("/account/login")
    public String login1(Model model) {
        String savedUser = cookieService.getValue("user");
        model.addAttribute("savedUser", savedUser);
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String login2(Model model) {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);
        if (un.equals("poly") && pw.equals("123")) {
            sessionService.set("username", un);
            if (rm) {
                cookieService.add("user", un, 10 * 24); 
            } else {
                cookieService.remove("user");
            }
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Sai username hoặc password!");
        }
        return "/account/login";
    }

    @GetMapping("/account/register")
    public String register1() {
        return "/account/register";
    }

    @PostMapping("/account/register")
    public String register2(Model model, MultipartFile photo) {
        try {
            String username = paramService.getString("username", "");
            String password = paramService.getString("password", "");
            File savedFile = paramService.save(photo, "/photos/");
            model.addAttribute("message", "Đăng ký thành công!");
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            if (savedFile != null) {
                model.addAttribute("photoPath", "/photos/" + savedFile.getName());
            }
        } catch (Exception e) {
            model.addAttribute("message", "Đăng ký thất bại: " + e.getMessage());
        }
        return "/account/register";
    }
}