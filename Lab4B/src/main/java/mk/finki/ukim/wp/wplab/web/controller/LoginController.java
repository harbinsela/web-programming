package mk.finki.ukim.wp.wplab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.wp.wplab.model.User;
import mk.finki.ukim.wp.wplab.model.exceptions.InvalidArgumentsException;
import mk.finki.ukim.wp.wplab.model.exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.wp.wplab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/login")
    @GetMapping
    public String getLoginPage(Model model) {
        // Return the name of the Thymeleaf template that will be used to render the login page
        model.addAttribute("bodyContent","login");
        return "master-template";
    }
    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        try {
            user = this.userService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/songs";
        } catch (RuntimeException ex) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
            return "login";
        } catch (InvalidArgumentsException | InvalidUserCredentialsException e) {
            throw new RuntimeException(e);
        }
    }
}