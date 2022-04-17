package com.example.theatre.repository.projections;

import java.sql.Timestamp;

public interface MovieShowingInstance {
    Integer getRoom_id();
    Timestamp getShow_datetime();
}
