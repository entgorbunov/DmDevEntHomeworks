package com.DmDev.collectionsPart2.base;

import java.util.Objects;

public class Film {
    private Integer id;
    private Integer yearOfRelease;
    private Month monthOfRelease;
    private Genre genre;
    private Double rating;

    public Film(Integer id, Integer yearOfRelease, Month monthOfRelease, Genre genre, Double rating) {
        this.id = id;
        this.yearOfRelease = yearOfRelease;
        this.monthOfRelease = monthOfRelease;
        this.genre = genre;
        this.rating = rating;
    }

    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    }

    public enum Genre {
        ACTION, DRAMA, COMEDY, FANTASTIC, HISTORICAL, THRILLER;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Month getMonthOfRelease() {
        return monthOfRelease;
    }

    public void setMonthOfRelease(Month monthOfRelease) {
        this.monthOfRelease = monthOfRelease;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && yearOfRelease == film.yearOfRelease && monthOfRelease == film.monthOfRelease && Double.compare(rating, film.rating) == 0 && Objects.equals(genre, film.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yearOfRelease, monthOfRelease, genre, rating);
    }

    @Override
    public String toString() {
        return "Film{" +
               "id=" + id +
               ", yearOfRelease=" + yearOfRelease +
               ", monthOfRelease=" + monthOfRelease +
               ", genre='" + genre + '\'' +
               ", rating=" + rating +
               '}';
    }

}

