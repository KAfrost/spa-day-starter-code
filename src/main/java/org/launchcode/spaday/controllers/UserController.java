package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    // route -> /user/add
    @GetMapping("/add")
    public String displayAddUserForm(){
        // user/add here reflects the path inside the templates folder
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm (Model model, @ModelAttribute User user, String verify){
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        if (user.getPassword().equals(verify)){
            return "user/index";
        } else{
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }
    }
}
