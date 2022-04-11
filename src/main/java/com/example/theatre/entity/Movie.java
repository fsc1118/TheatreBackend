package com.example.theatre.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long M_id;

    @Column(nullable = false)
    private String movieName;

    private int productionYear;

    public Movie() {

    }

    public Movie(Long m_id, String movieName, int productionYear, int productionMonth, String summary, String visualType, int length, int ticketSold, int earning, double rating) {
        M_id = m_id;
        this.movieName = movieName;
        this.productionYear = productionYear;
        this.productionMonth = productionMonth;
        this.summary = summary;
        this.visualType = visualType;
        this.length = length;
        this.ticketSold = ticketSold;
        this.earning = earning;
        this.rating = rating;
    }

    private int productionMonth;

    private String summary;

    private String visualType;

    private int length;

    private int ticketSold;

    private int earning;

    private double rating;

    public Long getM_id() {
        return M_id;
    }

    public void setM_id(Long m_id) {
        M_id = m_id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getProductionMonth() {
        return productionMonth;
    }

    public void setProductionMonth(int productionMonth) {
        this.productionMonth = productionMonth;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getVisualType() {
        return visualType;
    }

    public void setVisualType(String visualType) {
        this.visualType = visualType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold = ticketSold;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return productionYear == movie.productionYear && productionMonth == movie.productionMonth && length == movie.length && ticketSold == movie.ticketSold && earning == movie.earning && Double.compare(movie.rating, rating) == 0 && M_id.equals(movie.M_id) && movieName.equals(movie.movieName) && summary.equals(movie.summary) && visualType.equals(movie.visualType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(M_id, movieName, productionYear, productionMonth, summary, visualType, length, ticketSold, earning, rating);
    }
}