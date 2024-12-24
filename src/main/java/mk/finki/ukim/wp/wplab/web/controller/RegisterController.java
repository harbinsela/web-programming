package mk.finki.ukim.wp.wplab.web.controller;

import mk.finki.ukim.wp.wplab.model.exceptions.InvalidArgumentsException;
import mk.finki.ukim.wp.wplab.model.exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.wp.wplab.model.exceptions.UsenameAlreadyExistsException;
import mk.finki.ukim.wp.wplab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error,
                                  Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname
    ) {
        try {
            this.userService.register(username, password, repeatedPassword, name, surname);
            return "redirect:/login";
        } catch (RuntimeException ex) {
            // Redirect to the register page with an error message
            return "redirect:/register?error=" + ex.getMessage();
        } catch (PasswordsDoNotMatchException | InvalidArgumentsException | UsenameAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }
}