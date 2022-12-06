package com.example.hongparkproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")//url : localhost:8080/hi가 된다.
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "범철");
        return "greetings"; //templates/greeting.mustache를 찾아서 브라우저로 전송
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "범철이");
        return "goodbye";
    }
}
