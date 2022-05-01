package com.example.theatre.repository.projections;

import java.sql.Timestamp;

public interface PastPurchasesFilter {
    String getMovie_name();

    Timestamp getPurchase_datetime();

    Timestamp getShow_datetime();

    Double getTicket_price();

    Integer getRoom_id();

    Integer getSeat_num();
}
