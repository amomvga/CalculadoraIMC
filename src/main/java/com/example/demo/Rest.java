package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Rest {
    @GetMapping("/")
    public String page() {
        return "home";
    }

    @PostMapping(value = "/calculation")
    public String calculation(@RequestParam("peso") String peso, @RequestParam("altura") String altura, Model model) {
        double pesoI = Double.parseDouble(peso);
        double alturaI = Double.parseDouble(altura);
        double imc = pesoI / (alturaI * alturaI);
        model.addAttribute("calculado", true);
        String textimc = String.format("%.2f", imc);
        String text = "O seu IMC é de: " + textimc + "%";
        model.addAttribute("resposta", text);

        return "home";
    }
}
