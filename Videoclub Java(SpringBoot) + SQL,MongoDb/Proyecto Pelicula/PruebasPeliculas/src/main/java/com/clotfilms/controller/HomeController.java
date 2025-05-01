package com.clotfilms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 * Maneja las rutas de la página de inicio y el dashboard.
 */
@Controller
public class HomeController {

    /**
     * Maneja la solicitud GET para la página de inicio (landing page).
     *
     * @return El nombre de la plantilla Thymeleaf para la página de inicio.
     */
    @GetMapping("/")
    public String index() {
        return "index"; // Página de inicio (landing page)
    }

    /**
     * Maneja la solicitud GET para la página principal tras autenticarse.
     *
     * @return El nombre de la plantilla Thymeleaf para el dashboard.
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Página principal tras autenticarse
    }
}