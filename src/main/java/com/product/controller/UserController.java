package com.product.controller;

import com.product.model.User;
import com.product.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {
  private final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("mess","Nhap tai khoan va mat khau");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(Model model,HttpServletRequest request,
                         HttpServletResponse response) {
        Cookie cookie = null;
        Cookie[] arr = request.getCookies();
        if (arr != null){
            for (Cookie c: arr) {
                if (c.getName().equals("username")){
                    cookie = c;
                }

            }
            cookie.setMaxAge(0);
            response.addCookie(cookie);
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
            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(60*3);
            response.addCookie(cookie);


            return "redirect:/product";
        }else {
            model.addAttribute("mess","Sai tai khoan hoac mat khau");
            return "login";
        }


    }
}
