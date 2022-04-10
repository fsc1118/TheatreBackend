package com.example.theatre.repository.projections;

import java.util.Date;


/**
 * @author Min Lu
 *
 * Project for the stored procedure:
 *
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllMovies`()
 * BEGIN
 * 	SELECT DISTINCT movie.name, production_date, mpaa_rating, movie.movie_length_in_mins, movie_poster_url, summary, visual_type
 * 		FROM movie;
 * END
 *
 */
public interface MovieInstance {
    String getMovie_name();

    Date getProduction_date();

    String getRatings();

    Integer getMovie_length_in_minutes();

    String getImage_url();

    String getMovie_summary();

    String getType();
}
