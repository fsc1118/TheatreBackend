package com.example.theatre.repository.projections;

import java.sql.Timestamp;

public interface MovieInstanceFilter {
    Long getMovie_id();

    String getMovie_name();

    Timestamp getProduction_date();

    String getRatings();

    Integer getMovie_length_in_minutes();

    String getImage_url();

    String getMovie_summary();

    String getType();
}
