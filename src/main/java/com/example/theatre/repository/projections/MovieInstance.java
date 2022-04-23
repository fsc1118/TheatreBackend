package com.example.theatre.repository.projections;

import java.sql.Timestamp;


/**
 * @author Min Lu
 *
 * Projection for stored procedures returning movie name, production date, mpaa rating,
 * movie length, movie poster url, summary, and visual type.
 *
 * To use this projection, must create a procedure.
 *
 * Example Procedure:
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllMovies`()
 * BEGIN
 * 	SELECT DISTINCT movie.name, production_date, mpaa_rating, movie.movie_length_in_mins, movie_poster_url, summary, visual_type
 * 		FROM movie;
 * END
 */
public interface MovieInstance {
    String getMovie_name();

    Timestamp getProduction_date();

    String getRatings();

    Integer getMovie_length_in_minutes();

    String getImage_url();

    String getMovie_summary();

    String getType();

    Double getTotal_earnings();

    Integer getNumber_tickets_sold();
}
