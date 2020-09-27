package com.travel.socialmedia.services;

import com.travel.socialmedia.models.Location;
import com.travel.socialmedia.models.Profile;
import com.travel.socialmedia.models.User;
import com.travel.socialmedia.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfile(){
        return profileRepository.findAll();
    }

    public List<Map> getAllStatuses(){
        return profileRepository.getAllStatuses();
    }

    public List<Map> getAllStatusesByUser(int userId){
        return profileRepository.getAllStatusesByUser(userId);
    }

    public void save(Profile profile){
        profileRepository.save(profile);
    }

    public Optional<Profile> findById(int id){
        return profileRepository.findById(id);
    }

    public void delete(int id) {
        profileRepository.deleteById(id);
    }

    public Map getStatusById( int statusId){
        Map profileMap = profileRepository.getStatusById(statusId).get(0);
        return profileMap;
    }

}
