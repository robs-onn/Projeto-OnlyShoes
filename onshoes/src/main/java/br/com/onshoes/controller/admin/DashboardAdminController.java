package br.com.onshoes.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardAdminController {

    @GetMapping
    public String dashboard(Model model) {
        return "admin/dashboard-admin";
    }
}