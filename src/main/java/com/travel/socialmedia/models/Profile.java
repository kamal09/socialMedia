package com.travel.socialmedia.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="usre_id")
    private Integer userId;


    @Column(name="location_id")
    private Integer locationId;

    @Column(name="message")
    private String message;

    @Column(name="postingDate")
    private String postingDate;


    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public String getMessage() {
        return message;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }
}
