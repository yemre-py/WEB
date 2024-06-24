package com.web.controllers.users;

import com.web.models.users.Users;
import com.web.repositories.users.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new Users());
        return "index";
    }

    @PostMapping("/")
    public String signup(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {

        if(usersRepository.findByUsername(user.getUsername()).isPresent()) {
            result.rejectValue("username", "username.exists", "Username already exists");
        }
        if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
            result.rejectValue("email", "email.exists", "Email already exists");
        }

        if (result.hasErrors()) {
            return "index";
        }
        usersRepository.save(user);
        model.addAttribute("success", true);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
