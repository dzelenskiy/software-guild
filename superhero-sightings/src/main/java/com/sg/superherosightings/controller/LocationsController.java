/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.Location;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DZ
 */
@Controller
public class LocationsController {

    @Inject
    SuperheroSightingsDao dao;

    Location locView = null;

    String error = null;

    @GetMapping("/locations")
    public String locationsPage(HttpServletRequest request, Model model) {
        List<Location> locations = dao.getAllLocations();
        model.addAttribute("locations", locations);
        model.addAttribute("locView", locView);
        model.addAttribute("error", error);
        return "/locations";
    }

    @PostMapping("/addLocation")
    public String addLocation(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null || name.length() < 1 || name.length() > 45) {
            error = "Location name must not be empty and 1 - 45 characters";
            return "redirect:/locations";
        }
        String description = request.getParameter("description");
        if (description == null || description.length() < 1 || description.length() > 100) {
            error = "Description must not be empty and 1 - 100 characters";
            return "redirect:/locations";
        }
        String address = request.getParameter("address");
        if (address != null && address.length() > 45) {
            error = "Address must not be more than 45 characters";
            return "redirect:/locations";
        }
        String city = request.getParameter("city");
        if (city == null || city.length() < 1 || city.length() > 30) {
            error = "City must not be empty and 1 - 30 characters";
            return "redirect:/locations";
        }
        String state = request.getParameter("state");
        if (state == null || state.length() != 2) {
            error = "State must be 2 characters";
            return "redirect:/locations";
        }
        try {
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            if (latitude > 90 || latitude < -90) {
                error = "Latitudes must be between -90 to +90 degrees";
                return "redirect:/locations";
            }
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            if (longitude > 180 || longitude < -180) {
                error = "Longitudes must be between -180 to +180 degrees";
                return "redirect:/locations";
            }
            Location location = new Location();
            location.setName(name);
            location.setDescription(description);
            location.setAddress(address);
            location.setCity(city);
            location.setState(state);
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            dao.addLocation(location);
        } catch (NumberFormatException nfe) {
            error = "Latitude and Longitude must be a valid number";
            return "redirect:/locations";
        }

        error = null;
        return "redirect:/locations";
    }

    @GetMapping("/viewLocation")
    public String viewLocation(HttpServletRequest request, Model model) {
        locView = dao.getLocationById(Integer.parseInt(request.getParameter("id")));
        error = null;
        return "redirect:/locations";
    }

    @PostMapping("/editLocation")
    public String editLocation(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null || name.length() < 1 || name.length() > 45) {
            error = "Location name must not be empty and 1 - 45 characters";
            return "redirect:/locations";
        }
        String description = request.getParameter("description");
        if (description == null || description.length() < 1 || description.length() > 100) {
            error = "Description must not be empty and 1 - 100 characters";
            return "redirect:/locations";
        }
        String address = request.getParameter("address");
        if (address.length() != 0 && address.length() > 45) {
            error = "Address must not be more than 45 characters";
            return "redirect:/locations";
        }
        String city = request.getParameter("city");
        if (city == null || city.length() < 1 || city.length() > 30) {
            error = "Description must not be empty and 1 - 30 characters";
            return "redirect:/locations";
        }
        String state = request.getParameter("state");
        if (state == null || state.length() != 2) {
            error = "State must be 2 characters";
            return "redirect:/locations";
        }
        try {
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            if (latitude > 90 || latitude < -90) {
                error = "Latitudes must be between -90 to +90 degrees";
                return "redirect:/locations";
            }
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            if (longitude > 180 || longitude < -180) {
                error = "Longitudes must be between -180 to +180 degrees";
                return "redirect:/locations";
            }
            locView.setName(name);
            locView.setDescription(description);
            locView.setAddress(address);
            locView.setCity(city);
            locView.setState(state);
            locView.setLatitude(latitude);
            locView.setLongitude(longitude);
            dao.updateLocation(locView);
        } catch (NumberFormatException nfe) {
            error = "Latitude and Longitude must be a valid number";
            return "redirect:/locations";
        }

        locView = null;
        error = null;
        return "redirect:/locations";
    }

    @PostMapping("/cancelEditLocation")
    public String cancelEditLocation(HttpServletRequest request) {
        locView = null;
        error = null;
        return "redirect:/locations";
    }

    @GetMapping("/deleteLocation")
    public String deleteLocation(HttpServletRequest request) {
        dao.deleteLocation(Integer.parseInt(request.getParameter("id")));
        locView = null;
        error = null;
        return "redirect:/locations";
    }

}
