package ru.khismatullin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {
    @GetMapping("/intro")
    public String introPage() {
        return "intro";
    }
}
