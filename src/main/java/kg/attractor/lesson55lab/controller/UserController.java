package kg.attractor.lesson55lab.controller;

import kg.attractor.lesson55lab.dao.UserDao;
import kg.attractor.lesson55lab.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;

    @GetMapping
    public String profilePage(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/auth/login";
        }

        String email = principal.getName();
        User user = userDao.findAll().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/edit")
    public String editPage(Model model, Principal principal) {
        String email = principal.getName();
        User user = userDao.findAll().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .get();
        model.addAttribute("user", user);
        return "edit_profile";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam String name, @RequestParam String about, Principal principal) {
        String email = principal.getName();
        userDao.findAll().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .ifPresent(user -> {
                    user.setName(name);
                    user.setAbout(about);
                });
        return "redirect:/profile";
    }
}