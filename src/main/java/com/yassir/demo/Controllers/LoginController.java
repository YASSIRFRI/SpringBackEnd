package com.yassir.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    @GetMapping("/login")
    public ModelAndView greeting() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Greeting.html");
        return modelAndView;
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

}
