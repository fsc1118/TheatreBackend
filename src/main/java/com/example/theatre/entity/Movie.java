package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
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
    private String type;

    @Column(name = "movie_length_in_mins")
    private Integer movie_length_in_minutes;

    @Column(name = "num_tickets_sold")
    private Integer number_tickets_sold;

    @Column(name = "total_ticket_earnings")
    private Double total_earnings;

    @Column(name = "mpaa_rating")
    private String ratings;

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

    public Movie(Long movie_id,
                 String movie_name,
                 Date production_date,
                 String movie_summary,
                 String image_url,
                 String type,
                 String ratings) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.production_date = production_date;
        this.movie_summary = movie_summary;
        this.image_url = image_url;
        this.type = type;
        this.ratings = ratings;
    }

    public Movie(String movie_name,
                 Date production_date,
                 String movie_summary,
                 String image_url,
                 String type,
                 Integer movie_length_in_minutes,
                 String ratings) {
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
                  String type,
                  Integer movie_length_in_minutes,
                  Integer number_tickets_sold,
                  Double total_earnings,
                  String ratings) {
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
