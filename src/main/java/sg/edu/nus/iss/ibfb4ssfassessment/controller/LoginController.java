package sg.edu.nus.iss.ibfb4ssfassessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    
    // TODO: Task 6
    @GetMapping(path = {"/", "/index", "/login"})
    public String login(Model model) {

        Login userLogin = new Login();
        model.addAttribute("userLogin", userLogin);

        return "view0";
    }

    // TODO: Task 7
    @PostMapping("/login")
    public String processlogin(@Valid @ModelAttribute("userLogin") Login userLogin, BindingResult result,
    HttpSession session, Model model ) {

        if (result.hasErrors()) {
            return "view0";
        }
        
        return "view1";
    }
    

    // // TODO For the logout button shown on View 2
    // // On logout, session should be cleared
    // public String logout() {

    // }
    
}
