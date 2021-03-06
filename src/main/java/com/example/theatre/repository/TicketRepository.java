package com.example.theatre.repository;

import com.example.theatre.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.theatre.repository.projections.PastPurchasesFilter;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Procedure(procedureName = "sp_buyTicket")
    int addTicket(Long movieId, Integer roomId, String showDatetime, Integer seatNum, Long userId); // success = 0, not success = 1 or 2

    @Procedure(procedureName = "sp_filterPastPurchasesByPriceAndTitle")
    List<PastPurchasesFilter> getFilteredPastPurchases(String userID, Double minprice, Double maxprice, String title);

    @Modifying
    @Query(value = "DELETE FROM ticket t WHERE t.user_id = :userId", nativeQuery = true)
    void deleteTicketsOfUser(@Param("userId") Long userId);
}
