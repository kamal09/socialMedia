package com.travel.socialmedia;


import com.travel.socialmedia.models.UserPrincipal;
import com.travel.socialmedia.services.LocationService;
import com.travel.socialmedia.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ApplicationController {

//    @GetMapping("/index")
//    public String goHome(){
//        return "index";
//    }




    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
