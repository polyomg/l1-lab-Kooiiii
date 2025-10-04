package Lab3.Controller2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Lab3.model.Staff;
import org.springframework.ui.Model;


@Controller("staffController2")
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/list")
    public String list(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").salary(12345.678).photo("user.png").build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").salary(12345.678).photo("user.png").build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").salary(12345.678).photo("user.png").build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").salary(12345.678).photo("user.png").build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").salary(12345.678).photo("user.png").build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").salary(12345.678).photo("user.png").build()
        );

        model.addAttribute("list", list);
        return "/demo/staff-list";
    }
}