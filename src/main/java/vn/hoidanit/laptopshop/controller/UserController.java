package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    // ----dependency injection block----
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ----dependency injection block----

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("trung", "test");
        model.addAttribute("javaspring", "from controller with model");
        return "test";
    }

    // trang table user
    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("user1", users);
        return "admin/user/table-user";
    }

    // trang create User
    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // submit trang create User
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        System.out.println("RUN HERE: " + hoidanit);
        this.userService.handelSaveUser(hoidanit);
        return "redirect:/admin/user";
    }

    // trang deatail user
    @RequestMapping("/admin/user/{id}")
    public String getDetailUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/show"; // cái return này là trả lại đường dẫn của file trong code con đường dẫn ở trên
                                  // mới là đường dẫn trên localhot
    }

    // trang update user
    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User curUser = this.userService.getUserById(id);
        model.addAttribute("newUserUpdate", curUser);
        return "admin/user/update";
    }

    // submit trang update User
    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String updateUserPage(Model model, @ModelAttribute("newUserUpdate") User hoidanit) {
        User curUser = this.userService.getUserById(hoidanit.getId());
        System.out.println("RUN HERE: " + hoidanit);
        if (curUser != null) {

            curUser.setAddress(hoidanit.getAddress());
            curUser.setFullName(hoidanit.getFullName());
            curUser.setPhone(hoidanit.getPhone());
            this.userService.handelSaveUser(curUser);
        }
        return "redirect:/admin/user";
    }

    // xóa người dùng
    @RequestMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("deleteUser", new User());
        return "admin/user/delete";
    }

    // confirm xóa người dùng
    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)
    public String deleteUserPage(Model model, @ModelAttribute("deleteUser") User hoidanit) {
        this.userService.deleteUserById(hoidanit.getId());
        return "redirect:/admin/user";
    }
}
