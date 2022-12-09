package com.cp.librarymanagement.controller;

import com.cp.librarymanagement.entity.Location;
import com.cp.librarymanagement.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService service;

    @GetMapping
    public String getLocationPage(ModelMap model) {
        model.addAttribute("LOCATION_LIST", service.getAllLocation());
        return "page/location/index";
    }

    @GetMapping("/add")
    public String getAddLocationPage(ModelMap model){
        log.info("Get add location page");
        model.addAttribute("LOCATION", new Location());
        return "page/location/addOrUpdate";
    }

    @PostMapping("/save")
    public String saveLocation(Location entity){
        service.saveLocation(entity);
        return "redirect:/location";
    }

    @GetMapping("/update")
    public String getUpdateLocationPage(ModelMap model, @RequestParam("id") Long id){
        log.info("Get update location page - #id: " + id);
        Optional<Location> location = service.findLocationById(id);
        location.ifPresent(e -> model.addAttribute("LOCATION", location));
        return "page/location/addOrUpdate";
    }

    @GetMapping("/delete")
    public String deleteLocation(@RequestParam("id") Long id){
        service.deleteLocation(id);
        return "redirect:/location";
    }
}
