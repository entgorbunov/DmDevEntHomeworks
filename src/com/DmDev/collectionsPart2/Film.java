package com.DmDev.collectionsPart2;

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
}

