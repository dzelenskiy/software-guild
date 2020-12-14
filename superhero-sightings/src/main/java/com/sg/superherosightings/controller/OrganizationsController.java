/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.HeroVillain;
import com.sg.superherosightings.model.Organization;
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
public class OrganizationsController {

    @Inject
    SuperheroSightingsDao dao;

    Organization orgView = null;

    String error = null;

    @GetMapping("/organizations")
    public String organizationsPage(HttpServletRequest request, Model model) {
        List<Organization> organizations = dao.getAllOrganizations();
        List<HeroVillain> heroVillains = dao.getAllHeroVillains();
        model.addAttribute("organizations", organizations);
        model.addAttribute("orgView", orgView);
        model.addAttribute("heroVillains", heroVillains);
        model.addAttribute("error", error);
        return "/organizations";
    }

    @PostMapping("/addOrganization")
    public String addOrganization(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null || name.length() < 1 || name.length() > 30) {
            error = "Location name must not be empty and 1 - 30 characters";
            return "redirect:/organizations";
        }
        String description = request.getParameter("description");
        if (description.length() != 0 && description.length() > 100) {
            error = "Description must not be more than 100 characters";
            return "redirect:/organizations";
        }
        String address = request.getParameter("address");
        if (address.length() != 0 && address.length() > 30) {
            error = "Address must not be more than 30 characters";
            return "redirect:/organizations";
        }
        String city = request.getParameter("city");
        if (city.length() != 0 && city.length() > 30) {
            error = "City must not be more than 30 characters";
            return "redirect:/organizations";
        }
        String state = request.getParameter("state");
        if (state.length() != 0 && state.length() != 2) {
            error = "State must be 2 characters";
            return "redirect:/organizations";
        }
        String phone = request.getParameter("phone");
        if (phone.length() != 0 && phone.length() != 10) {
            error = "Phone must be 10 characters";
            return "redirect:/organizations";
        }
        String email = request.getParameter("email");
        if (email.length() != 0 && email.length() > 45) {
            error = "Email cannot be greater than 45 characters";
            return "redirect:/organizations";
        }
        String website = request.getParameter("website");
        if (website.length() != 0 && website.length() > 45) {
            error = "State cannot be greater than 45 characters";
            return "redirect:/organizations";
        }
        Organization organization = new Organization();
        organization.setName(name);
        organization.setDescription(description);
        organization.setAddress(address);
        organization.setCity(city);
        organization.setState(state);
        organization.setPhone(phone);
        organization.setEmail(email);
        organization.setWebsite(website);
        List<HeroVillain> orgHVs = new ArrayList<>();
        String[] selectedHVs = request.getParameterValues("heroVillain");
        if (selectedHVs == null) {
            error = "You must choose at least one Superhero / Supervillain";
            return "redirect:/organizations";
        }
        for (String selectedId : selectedHVs) {
            orgHVs.add(dao.getHeroVillainById(Integer.parseInt(selectedId)));
        }
        organization.setHeroVillains(orgHVs);
        dao.addOrganization(organization);
        error = null;
        return "redirect:/organizations";
    }

    @GetMapping("/viewOrganization")
    public String viewOrganization(HttpServletRequest request, Model model) {
        orgView = dao.getOrganizationById(Integer.parseInt(request.getParameter("id")));
        return "redirect:/organizations";
    }

    @PostMapping("/editOrganization")
    public String editOrganization(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null || name.length() < 1 || name.length() > 30) {
            error = "Organization name must not be empty and 1 - 30 characters";
            return "redirect:/organizations";
        }
        String description = request.getParameter("description");
        if (description.length() != 0 && description.length() > 100) {
            error = "Description must not be more than 100 characters";
            return "redirect:/organizations";
        }
        String address = request.getParameter("address");
        if (address.length() != 0 && address.length() > 30) {
            error = "Address must not be more than 30 characters";
            return "redirect:/organizations";
        }
        String city = request.getParameter("city");
        if (city.length() != 0 && city.length() > 30) {
            error = "City must not be more than 30 characters";
            return "redirect:/organizations";
        }
        String state = request.getParameter("state");
        if (state.length() != 0 && state.length() != 2) {
            error = "State must be 2 characters";
            return "redirect:/organizations";
        }
        String phone = request.getParameter("phone");
        if (phone.length() != 0 && phone.length() != 10) {
            error = "Phone must be 10 characters";
            return "redirect:/organizations";
        }
        String email = request.getParameter("email");
        if (email.length() != 0 && email.length() > 45) {
            error = "Email cannot be greater than 45 characters";
            return "redirect:/organizations";
        }
        String website = request.getParameter("website");
        if (website.length() != 0 && website.length() > 45) {
            error = "State cannot be greater than 45 characters";
            return "redirect:/organizations";
        }

        orgView.setName(name);
        orgView.setDescription(description);
        orgView.setAddress(address);
        orgView.setCity(city);
        orgView.setState(state);
        orgView.setPhone(phone);
        orgView.setEmail(email);
        orgView.setWebsite(website);
        List<HeroVillain> orgHVs = new ArrayList<>();
        String[] selectedHVs = request.getParameterValues("heroVillain");
        if (selectedHVs == null) {
            error = "You must choose at least one Superhero / Supervillain";
            return "redirect:/organizations";
        }
        for (String selectedId : selectedHVs) {
            orgHVs.add(dao.getHeroVillainById(Integer.parseInt(selectedId)));
        }
        orgView.setHeroVillains(orgHVs);
        dao.updateOrganization(orgView);
        orgView = null;
        error = null;
        return "redirect:/organizations";
    }

    @PostMapping("/cancelEditOrganization")
    public String cancelEditOrganization(HttpServletRequest request) {
        orgView = null;
        error = null;
        return "redirect:/organizations";
    }

    @GetMapping("/deleteOrganization")
    public String deleteOrganization(HttpServletRequest request) {
        dao.deleteOrganization(Integer.parseInt(request.getParameter("id")));
        orgView = null;
        error = null;
        return "redirect:/organizations";
    }

}
