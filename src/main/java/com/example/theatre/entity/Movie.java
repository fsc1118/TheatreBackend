package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Min Lu + Fang Shicheng
 *
 * Movie entity.
 */

@NoArgsConstructor
@ToString
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
    private Timestamp production_date;

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

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private Set<Ticket> tickets;
}
