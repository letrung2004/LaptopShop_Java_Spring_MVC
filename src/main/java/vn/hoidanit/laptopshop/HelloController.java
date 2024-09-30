package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Hello JAVA! rename";
    }

    // user
    @GetMapping("/user")
    public String userPage() {
        return "Hello JAVA! user ";
    }

    // admin
    @GetMapping("/admin")
    public String adminPage() {
        return "Hello JAVA! admin";
    }
}
