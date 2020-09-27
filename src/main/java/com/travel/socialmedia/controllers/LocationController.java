package com.travel.socialmedia.controllers;

import com.travel.socialmedia.models.Location;
import com.travel.socialmedia.models.UserPrincipal;
import com.travel.socialmedia.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/locations")
    public String getLocations(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

        List<Location> locationList = locationService.getAllLocations();
        model.addAttribute("locations", locationList);
        model.addAttribute("userName", userPrincipal.getUsername());
        return "location";
    }

    @PostMapping(value = "/locations/addNew")
    public String addLocation(Location location1) {

        locationService.save(location1);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id) {
        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}
