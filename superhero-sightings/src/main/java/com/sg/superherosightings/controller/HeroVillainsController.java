/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.HeroVillain;
import com.sg.superherosightings.model.Organization;
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
public class HeroVillainsController {

    @Inject
    SuperheroSightingsDao dao;

    HeroVillain hvView = null;

    String error = null;

    @GetMapping("/herovillains")
    public String heroVillainsPage(HttpServletRequest request, Model model) {
        List<HeroVillain> heroVillains = dao.getAllHeroVillains();
        model.addAttribute("heroVillains", heroVillains);
        model.addAttribute("hvView", hvView);
        model.addAttribute("error", error);
        return "/herovillains";
    }

    @PostMapping("/addHeroVillain")
    public String addHeroVillain(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null || name.length() < 1 || name.length() > 30) {
            error = "Name must not be empty and 1 - 30 characters";
            return "redirect:/herovillains";
        }
        String description = request.getParameter("description");
        if (description.length() != 0 && description.length() > 100) {
            error = "Description must not be more than 100 characters";
            return "redirect:/herovillains";
        }
        String power = request.getParameter("power");
        if (power.length() != 0 && power.length() > 45) {
            error = "Power must not be more than 45 characters";
            return "redirect:/herovillains";
        }

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName(name);
        heroVillain.setDescription(description);
        heroVillain.setPower(power);
        dao.addHeroVillain(heroVillain);
        error = null;
        return "redirect:/herovillains";
    }

    @GetMapping("/viewHeroVillain")
    public String viewHeroVillain(HttpServletRequest request, Model model) {
        hvView = dao.getHeroVillainById(Integer.parseInt(request.getParameter("id")));
        return "redirect:/herovillains";
    }

    @PostMapping("/editHeroVillain")
    public String editHeroVillain(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null || name.length() < 1 || name.length() > 30) {
            error = "Name must not be empty and 1 - 30 characters";
            return "redirect:/herovillains";
        }
        String description = request.getParameter("description");
        if (description.length() != 0 && description.length() > 100) {
            error = "Description must not be more than 100 characters";
            return "redirect:/herovillains";
        }
        String power = request.getParameter("power");
        if (power.length() != 0 && power.length() > 45) {
            error = "Power must not be more than 45 characters";
            return "redirect:/herovillains";
        }

        hvView.setName(name);
        hvView.setDescription(description);
        hvView.setPower(power);
        dao.updateHeroVillain(hvView);
        hvView = null;
        error = null;
        return "redirect:/herovillains";
    }

    @PostMapping("/cancelEditHeroVillain")
    public String cancelEditHeroVillain(HttpServletRequest request) {
        hvView = null;
        error = null;
        return "redirect:/herovillains";
    }

    @GetMapping("/deleteHeroVillain")
    public String deleteHeroVillain(HttpServletRequest request) {
        dao.deleteHeroVillain(Integer.parseInt(request.getParameter("id")));
        hvView = null;
        error = null;
        return "redirect:/herovillains";
    }

}
