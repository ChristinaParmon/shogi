package com.example.shogi.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    // private final UserService userService;

    //    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
