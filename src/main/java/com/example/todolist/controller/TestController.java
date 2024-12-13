package com.example.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String testPage() {
        return "test"; // Ім'я HTML-файлу без розширення
    }
}
