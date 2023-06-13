package com.product.controller;

import com.product.model.User;
import com.product.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("user")
public class UserController {
  private final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
@ModelAttribute("user")
public User setUser(){
        return new User();
}

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("mess","Nhap tai khoan va mat khau");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(@SessionAttribute("username") String username,HttpSession session) {
        if (username!=null){
            session.removeAttribute("username");
        }
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String doLogin(Model model , @ModelAttribute("user") User user, HttpServletRequest
                          request, HttpServletResponse response) {
        Optional<User> myUser = userService.getUserByUsername(user.getUsername());
        if (myUser.isEmpty()){

            model.addAttribute("mess","Sai tai khoan hoac mat khau");
            return "login";
        }

        if (user.getUsername().equals(myUser.get().getUsername())&&
             user.getPassword().equals(myUser.get().getPassword()))
        {

            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("username" ,user.getUsername());
            session.setMaxInactiveInterval(180);

            return "redirect:/product";
        }else {
            model.addAttribute("mess","Sai tai khoan hoac mat khau");
            return "login";
        }


    }
}
