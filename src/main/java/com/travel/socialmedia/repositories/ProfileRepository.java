package com.travel.socialmedia.repositories;

import com.travel.socialmedia.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Query("SELECT \n" +
            "p.id as id,\n" +
            "p.message as message,\n" +
            "p.postingDate as postingdate,\n" +
            "l.locationName as location,\n" +
            "u.username AS username\n" +
            "FROM Profile p INNER JOIN Location l ON l.id = p.locationId INNER JOIN User u ON u.id = p.userId")
    List<Map> getAllStatuses();


    @Query("SELECT " +
            "p.id as id," +
            "p.message as message," +
            "p.postingDate as postingdate," +
            "l.locationName as location," +
            "u.username AS username " +
            "FROM Profile p INNER JOIN Location l ON l.id = p.locationId INNER JOIN User u ON u.id = p.userId " +
            "where u.id =:userId")
    List<Map> getAllStatusesByUser(@Param("userId") int userId);

    @Query("SELECT " +
            "p.id as id," +
            "p.message as message," +
            "p.postingDate as postingdate," +
            "l.locationName as location," +
            "l.id as locationid," +
            "u.username AS username " +
            "FROM Profile p INNER JOIN Location l ON l.id = p.locationId INNER JOIN User u ON u.id = p.userId " +
            "where p.id =:statusId")
    List<Map> getStatusById(@Param("statusId") int statusId);
}
