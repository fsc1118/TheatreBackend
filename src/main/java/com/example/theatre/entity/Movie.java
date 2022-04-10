package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Long movie_id;

    @Column(name = "name", nullable = false)
    private String movie_name;

    @Column(name = "production_date")
    private Date production_date;

    @Column(name = "summary")
    @Lob
    private String movie_summary;

    @Column(name = "movie_poster_url")
    private String image_url;

    @Column(name = "visual_type")
    private VisualType type;

    @Column(name = "movie_length_in_mins")
    private Integer movie_length_in_minutes;

    @Column(name = "num_tickets_sold")
    private Integer number_tickets_sold;

    @Column(name = "total_ticket_earnings")
    private Double total_earnings;

    @Column(name = "mpaa_rating")
    private MPAARatings ratings;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    Set<MovieShowing> movieShowings;

    public Movie() {
    }

    public Movie(String movie_name) {
        this.movie_name = movie_name;
        this.production_date = null;
        this.movie_summary = null;
        this.image_url = null;
        this.type = null;
        this.movie_length_in_minutes = 0;
        this.number_tickets_sold = 0;
        this.total_earnings = 0.0;
        this.ratings = null;
    }

    public Movie(String movie_name,
                 Date production_date,
                 String movie_summary,
                 String image_url,
                 VisualType type,
                 Integer movie_length_in_minutes,
                 MPAARatings ratings) {
        this.movie_name = movie_name;
        this.production_date = production_date;
        this.movie_summary = movie_summary;
        this.image_url = image_url;
        this.type = type;
        this.movie_length_in_minutes = movie_length_in_minutes;
        this.number_tickets_sold = 0;
        this.total_earnings = 0.0;
        this.ratings = ratings;
    }

    public Movie(String movie_name,
                  Date production_date,
                  String movie_summary,
                  String image_url,
                  VisualType type,
                  Integer movie_length_in_minutes,
                  Integer number_tickets_sold,
                  Double total_earnings,
                  MPAARatings ratings) {
        this.movie_name = movie_name;
        this.production_date = production_date;
        this.movie_summary = movie_summary;
        this.image_url = image_url;
        this.type = type;
        this.movie_length_in_minutes = movie_length_in_minutes;
        this.number_tickets_sold = number_tickets_sold;
        this.total_earnings = total_earnings;
        this.ratings = ratings;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public String getMovie_summary() {
        return movie_summary;
    }

    public void setMovie_summary(String movie_summary) {
        this.movie_summary = movie_summary;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public VisualType getType() {
        return type;
    }

    public void setType(VisualType type) {
        this.type = type;
    }

    public Integer getMovie_length_in_minutes() {
        return movie_length_in_minutes;
    }

    public void setMovie_length_in_minutes(Integer movie_length_in_minutes) {
        this.movie_length_in_minutes = movie_length_in_minutes;
    }

    public Integer getNumber_tickets_sold() {
        return number_tickets_sold;
    }

    public void setNumber_tickets_sold(Integer number_tickets_sold) {
        this.number_tickets_sold = number_tickets_sold;
    }

    public Double getTotal_earnings() {
        return total_earnings;
    }

    public void setTotal_earnings(Double total_earnings) {
        this.total_earnings = total_earnings;
    }

    public MPAARatings getRatings() {
        return ratings;
    }

    public void setRatings(MPAARatings ratings) {
        this.ratings = ratings;
    }

    public VisualType getVisualType(String type) {
        VisualType result = null;
        switch (type) {
            case "2d": case "2D":
                result = VisualType.TWO_D;
                break;
            case "3d": case "3D":
                result = VisualType.THREE_D;
                break;
            case "4d": case "4D":
                result = VisualType.FOUR_D;
                break;
        }
        return result;
    }

    public MPAARatings getMPAARatings(String rating) {
        MPAARatings result = null;
        switch (rating) {
            case "G": case "g":
                result = MPAARatings.G;
                break;
            case "PG": case "pg":
                result = MPAARatings.PG;
                break;
            case "PG-13": case "pg-13": case "pg13":
                result = MPAARatings.PG_13;
                break;
            case "R": case "r":
                result = MPAARatings.R;
                break;
            case "NC-17": case "nc-17": case "nc17":
                result = MPAARatings.NC_17;
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", production_date=" + production_date +
                ", movie_summary='" + movie_summary + '\'' +
                ", image_url='" + image_url + '\'' +
                ", type=" + type +
                ", movie_length_in_minutes=" + movie_length_in_minutes +
                ", number_tickets_sold=" + number_tickets_sold +
                ", total_earnings=" + total_earnings +
                ", ratings=" + ratings +
                '}';
    }
}
