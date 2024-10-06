package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
    // ----dependency injection block----
    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    // ----dependency injection block----

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("trung", "test");
        model.addAttribute("javaspring", "from controller with model");
        return "test";// cái return này là trả lại đường dẫn của file trong code con đường dẫn ở trên
        // mới là đường dẫn trên localhot
    }

    // trang table user
    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("user1", users);
        return "admin/user/show";
    }

    // trang create User
    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // submit trang create User
    @PostMapping("/admin/user/create")
    public String createUserPage(Model model,
            @ModelAttribute("newUser") User hoidanit,
            @RequestParam("hoidanitFile") MultipartFile file) {
        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(hoidanit.getPassword());
        hoidanit.setAvatar(avatar);
        hoidanit.setPassword(hashPassword);
        hoidanit.setRole(this.userService.getRoleByName(hoidanit.getRole().getName()));
        this.userService.handelSaveUser(hoidanit);
        return "redirect:/admin/user";
    }

    // trang deatail user
    @GetMapping("/admin/user/{id}")
    public String getDetailUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    // trang update user
    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User curUser = this.userService.getUserById(id);
        model.addAttribute("newUserUpdate", curUser);
        return "admin/user/update";
    }

    // submit trang update User
    @PostMapping("/admin/user/update")
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
    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("deleteUser", new User());
        return "admin/user/delete";
    }

    // confirm xóa người dùng
    @PostMapping("/admin/user/delete")
    public String deleteUserPage(Model model, @ModelAttribute("deleteUser") User hoidanit) {
        this.userService.deleteUserById(hoidanit.getId());
        return "redirect:/admin/user";
    }
}
