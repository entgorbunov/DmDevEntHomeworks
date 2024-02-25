package com.DmDev.collectionsPart2.base;

import java.util.Objects;

public class Film {
    private int id;
    private int yearOfRelease;
    private int monthOfRelease;
    private String genre;
    private double rating;

    public Film(int id, int yearOfRelease, int monthOfRelease, String genre, double rating) {
        this.id = id;
        this.yearOfRelease = yearOfRelease;
        this.monthOfRelease = monthOfRelease;
        this.genre = genre;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public int getMonthOfRelease() {
        return monthOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setMonthOfRelease(int monthOfRelease) {
        this.monthOfRelease = monthOfRelease;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
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

