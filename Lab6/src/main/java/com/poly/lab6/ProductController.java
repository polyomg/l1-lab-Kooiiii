package Lab6.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Lab6.dao.ProductDAO;
import Lab6.entity.Product;

@Controller
public class ProductController {
    @Autowired
    ProductDAO dao;

    // Bài 3: Sắp xếp
    @RequestMapping("/product/sort")
    public String sort(Model model,
    		@RequestParam("field") Optional<String> field) {
    		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
    		model.addAttribute("field", field.orElse("price").toUpperCase());
    		List<Product> items = dao.findAll(sort);
    		model.addAttribute("items", items);
    		return "product/sort";
    		}


    // Bài 4: Phân trang
    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }
        @RequestMapping("/product/pageAndSort")
        public String paginateAndSort(Model model, @RequestParam("p") Optional<Integer> p, @RequestParam("field") Optional<String> field) {
            int pageIndex = p.orElse(0);
            String sortField = field.orElse("price");
            Pageable pageable = PageRequest.of(pageIndex, 5, Sort.by(Sort.Direction.DESC, sortField));
            Page<Product> page = dao.findAll(pageable);
            model.addAttribute("page", page);
            model.addAttribute("field", sortField.toUpperCase());
            return "product/pageAndSort";

    }
}
