package sg.edu.nus.iss.ibfb4ssfassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Login;
import sg.edu.nus.iss.ibfb4ssfassessment.service.DatabaseService;

@Controller
@RequestMapping
public class MovieController {

    @Autowired
    DatabaseService dbService;

    // TODO: Task 8
    @GetMapping("/view2")
    public String displayMovies(HttpSession session, Model model) {

        // if there is no session
        if (session.getAttribute("userLogin") == null) {
            return "redirect:/";
        }

        try {
            model.addAttribute("movielist", dbService.getAllMovies());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "view2";
    }

    // // TODO: Task 9
    // public String bookMovie() {

    // }

    // TODO: Task 9
    // ... ...

}
