package CabanasSyC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CabanasSyC.service.AuthService;
import jakarta.servlet.http.HttpSession;

@Controller
public class authController {
    @Autowired
    private AuthService authService; 
    @Autowired
    private HttpSession session;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        var user = authService.loadUserByUsername(email);
        if(user == null){
            model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
            return "login";
        } 
        session.removeAttribute("username");
        session.setAttribute("username", user.getUsername()); 
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
}
