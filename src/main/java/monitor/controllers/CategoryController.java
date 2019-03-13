package monitor.controllers;

import monitor.data.UserRepository;
import monitor.models.Category;
import monitor.data.CategoryRepository;
import monitor.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/category")
@SessionAttributes("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("title", "My Categories");
        model.addAttribute("categories", categoryRepo.findAll());
        return "category/index";
    }

    @GetMapping("add")
    public String add(Model model, Principal principal) {
        model.addAttribute(new Category());
        model.addAttribute("title", "Add Category");

        /*String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);*/

        return "category/add";
    }

    @PostMapping("add")
    public String add(Model model, @ModelAttribute @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            return "category/add";
        }
        else {
            categoryRepo.save(category);
            return "redirect:/category";
        }
    }
}