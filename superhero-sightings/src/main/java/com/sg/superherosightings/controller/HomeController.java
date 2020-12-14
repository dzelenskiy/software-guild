/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.HeroVillain;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Sighting;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DZ
 */
@Controller
public class HomeController {

    @Inject
    SuperheroSightingsDao dao;

    @GetMapping("/")
    public String loadHome(HttpServletRequest request, Model model) {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(HttpServletRequest request, Model model) {
        List<Sighting> sightings = dao.getLastTenSightings();
        model.addAttribute("sightings", sightings);
        return "/home";
    }

}
