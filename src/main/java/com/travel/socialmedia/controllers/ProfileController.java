package com.travel.socialmedia.controllers;

import com.travel.socialmedia.models.Profile;
import com.travel.socialmedia.models.UserPrincipal;
import com.travel.socialmedia.services.LocationService;
import com.travel.socialmedia.services.ProfileService;
import com.travel.socialmedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private UserService userService;


    @GetMapping(value = "/index")
    public String getAllStatuses(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

        List<Map> statuses = profileService.getAllStatuses();
        model.addAttribute("statuses", statuses);
        model.addAttribute("userName", userPrincipal.getUsername());

        return "index";
    }

    @GetMapping(value = "/profile")
    public String getAllStatusesByUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
        List<Map> statuses = profileService.getAllStatusesByUser(userPrincipal.getUserId());
        model.addAttribute("statuses", statuses);
        model.addAttribute("locations", locationService.getAllLocations());
        model.addAttribute("userName", userPrincipal.getUsername());

        return "profilepage";
    }


    @PostMapping(value = "/profile/addNew")
    public String addStatus(@RequestParam Map<String, Object> parameters) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

        Profile profile = new Profile();
        int userId = userPrincipal.getUserId();
        profile.setUserId(userId);
        profile.setLocationId(Integer.parseInt(parameters.get("locationid").toString()));
        profile.setMessage((String) parameters.get("message"));

        SimpleDateFormat dnt = new SimpleDateFormat("dd/MM/yyyy :: HH:mm:ss");
        Date date = new Date();

        profile.setPostingDate(dnt.format(date));

        profileService.save(profile);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile/findById")
    @ResponseBody
    public Map findById(int id) {
        Map map = profileService.getStatusById(id);
        return map;
    }

    @PostMapping(value = "/profile/update")
    public String updateStatus(@RequestParam Map<String, Object> parameters) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

        Profile profile = new Profile();
        int userId = userPrincipal.getUserId();
        profile.setUserId(userId);
        profile.setLocationId(Integer.parseInt(parameters.get("locationid").toString()));
        profile.setId(Integer.parseInt(parameters.get("statusId").toString()));
        profile.setMessage((String) parameters.get("message"));

        SimpleDateFormat dnt = new SimpleDateFormat("dd/MM/yyyy :: HH:mm:ss");
        Date date = new Date();

        profile.setPostingDate(dnt.format(date));

        profileService.save(profile);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        profileService.delete(id);
        return "redirect:/profile";
    }
}
