package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    // ----dependency injection lock----
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ----dependency injection lock----

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("trung", "test");
        model.addAttribute("javaspring", "from controller with model");
        return "test";
    }

    // trang create User
    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // submit trang create User
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        System.out.println("RUN HERE: " + hoidanit);
        this.userService.handelSaveUser(hoidanit);
        return "test";
    }
}
