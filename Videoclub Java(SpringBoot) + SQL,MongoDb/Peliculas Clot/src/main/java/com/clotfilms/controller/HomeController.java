package com.clotfilms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Página de inicio (landing page)
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Página principal tras autenticarse
    }
}
