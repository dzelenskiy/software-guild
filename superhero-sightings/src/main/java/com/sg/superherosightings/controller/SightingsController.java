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
public class SightingsController {

    @Inject
    SuperheroSightingsDao dao;

    Sighting sightView = null;

    String error = null;

    @GetMapping("/sightings")
    public String sightingsPage(HttpServletRequest request, Model model) {
        List<Sighting> sightings = dao.getAllSightings();
        List<Location> locations = dao.getAllLocations();
        List<HeroVillain> heroVillains = dao.getAllHeroVillains();
        model.addAttribute("sightings", sightings);
        model.addAttribute("locations", locations);
        model.addAttribute("heroVillains", heroVillains);
        model.addAttribute("sightView", sightView);
        model.addAttribute("error", error);
        return "/sightings";
    }

    @PostMapping("/addSighting")
    public String addSighting(HttpServletRequest request) {
        String stringDate = request.getParameter("date");
        if (stringDate.isEmpty()) {
            error = "You must choose a sighting date";
            return "redirect:/sightings";
        }
        String location = request.getParameter("location");
        if (location.contains("-Select One-")) {
            error = "You must choose a sighting location";
            return "redirect:/sightings";
        }
        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse(request.getParameter("date")));
        sighting.setLocation(dao.getLocationById(Integer.parseInt(request.getParameter("location"))));
        String[] selectedHVs = request.getParameterValues("heroVillain");
        if (selectedHVs == null) {
            error = "You must choose at least one Superhero / Supervillain";
            return "redirect:/sightings";
        }
        List<HeroVillain> sightHVs = new ArrayList<>();
        for (String selectedHV : selectedHVs) {
            sightHVs.add(dao.getHeroVillainById(Integer.parseInt(selectedHV)));
        }
        sighting.setHeroVillains(sightHVs);
        dao.addSighting(sighting);
        error = null;
        return "redirect:/sightings";
    }

    @GetMapping("/viewSighting")
    public String viewSighting(HttpServletRequest request, Model model) {
        sightView = dao.getSightingById(Integer.parseInt(request.getParameter("id")));
        return "redirect:/sightings";
    }

    @PostMapping("/editSighting")
    public String editSighting(HttpServletRequest request) {
        String stringDate = request.getParameter("date");
        if (stringDate.isEmpty()) {
            error = "You must choose a sighting date";
            return "redirect:/sightings";
        }
        String location = request.getParameter("location");
        if (location.contains("-Select One-")) {
            error = "You must choose a sighting location";
            return "redirect:/sightings";
        }
        sightView.setDate(LocalDate.parse(request.getParameter("date")));
        sightView.setLocation(dao.getLocationById(Integer.parseInt(request.getParameter("location"))));
        String[] selectedHVs = request.getParameterValues("heroVillain");
        if (selectedHVs == null) {
            error = "You must choose at least one Superhero / Supervillain";
            return "redirect:/sightings";
        }
        List<HeroVillain> sightHVs = new ArrayList<>();
        for (String selectedHV : selectedHVs) {
            sightHVs.add(dao.getHeroVillainById(Integer.parseInt(selectedHV)));
        }
        sightView.setHeroVillains(sightHVs);
        dao.updateSighting(sightView);
        sightView = null;
        error = null;
        return "redirect:/sightings";
    }

    @PostMapping("/cancelEditSighting")
    public String cancelEditSighting(HttpServletRequest request) {
        sightView = null;
        error = null;
        return "redirect:/sightings";
    }

    @GetMapping("/deleteSighting")
    public String deleteSighting(HttpServletRequest request) {
        dao.deleteSighting(Integer.parseInt(request.getParameter("id")));
        sightView = null;
        error = null;
        return "redirect:/sightings";
    }

}
