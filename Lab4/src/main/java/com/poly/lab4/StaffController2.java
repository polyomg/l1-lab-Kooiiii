package Lab4.Controller2;

import Lab4.model2.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/staff")
public class StaffController2 {

    @GetMapping("/form2")
    public String createForm2(Model model) {
        model.addAttribute("staff", new Staff()); 
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên");
        return "/demo/staff-validate";
    }

    @PostMapping("/save2")
    public String createSave2(Model model,
                              @RequestParam("photo_file") MultipartFile photoFile,
                              @Valid @ModelAttribute("staff") Staff staff,
                              Errors errors) {

        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }

        return "/demo/staff-validate";
    }
}
