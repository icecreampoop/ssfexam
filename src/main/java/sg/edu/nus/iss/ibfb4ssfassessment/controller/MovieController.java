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
import sg.edu.nus.iss.ibfb4ssfassessment.model.Booking;
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

        Booking booking = new Booking();
        model.addAttribute("booking", booking);

        try {
            model.addAttribute("movielist", dbService.getAllMovies());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "view2";
    }

    @GetMapping(path = "/booking/{id}")
    public String bookMovie(@PathVariable("id") String id,
            @Valid @ModelAttribute() Booking booking, BindingResult result,
            HttpSession session, Model model) {

        // if not old enough return view 3

        // sry couldnt finish the exam in time as im learning path variable live lmao
        try {
            model.addAttribute("movietitle", dbService.getMovieById(Integer.parseInt(id)).getTitle());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "view4";
    }

}
