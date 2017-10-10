package com.nmodus.demo.entities.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping()
    public String index(Model model){
        model.addAttribute("ejercicioFiscal","2017"); // Ejercicio fiscal
        model.addAttribute("hayAnioCerrado", "No"); // indica si hay o no un año cerrado
        model.addAttribute("now", ZonedDateTime.now().getYear()); //año actual
        model.addAttribute("index","Bienvenido");
        return "index";
    }

}
