package com.travel.socialmedia.services;

import com.travel.socialmedia.models.Location;
import com.travel.socialmedia.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void save(Location location) {
        locationRepository.save(location);
    }

    public Optional<Location> findById(int id) {
        return locationRepository.findById(id);
    }

    public void delete(int id) {
        locationRepository.deleteById(id);
    }
}
