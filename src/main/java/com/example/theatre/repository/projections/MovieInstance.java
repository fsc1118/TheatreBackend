package com.example.theatre.repository.projections;

import java.util.Date;

public interface MovieInstance {
    String getMovie_name();

    Date getProduction_date();

    String getRatings();

    Integer getMovie_length_in_minutes();

    String getImage_url();

    String getMovie_summary();

    String getType();
}
