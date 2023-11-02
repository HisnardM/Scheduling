package com.agendamento.crm.hisnard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    @Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        // Implemente o logout aqui
        return "redirect:/login?logout";
    }
}

}
