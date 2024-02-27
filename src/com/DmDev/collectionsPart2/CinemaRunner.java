package com.DmDev.collectionsPart2;

import com.DmDev.collectionsPart2.base.Cinema;
import com.DmDev.collectionsPart2.base.Film;
import com.DmDev.collectionsPart2.base.Film.Month;
import com.DmDev.collectionsPart2.base.Film.Genre;
import com.DmDev.collectionsPart2.utility.CinemaUtils;

public class CinemaRunner {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();


        CinemaUtils.addFilm(cinema.getFilmsByYear(), new Film(1, 2020, Month.MAY, Genre.ACTION, 8.5));
        CinemaUtils.addFilm(cinema.getFilmsByYear(), new Film(2, 2020, Month.JUNE, Genre.DRAMA, 9.0));
        CinemaUtils.addFilm(cinema.getFilmsByYear(), new Film(3, 2021, Month.MAY, Genre.ACTION, 7.5));
        CinemaUtils.addFilm(cinema.getFilmsByYear(), new Film(4, 2021, Month.JUNE, Genre.COMEDY, 8.0));

        System.out.println("\nFilms in 2020: " + CinemaUtils.getFilmsByYear(cinema.getFilmsByYear(), 2020));
        System.out.println("\n_______________________________________________________________");

        System.out.println("\nAction films: " + CinemaUtils.getFilmsByGenre(cinema.getFilmsByYear(), Genre.ACTION));
        System.out.println("\n_______________________________________________________________");

        System.out.println("\nFilms in June 2021: " + CinemaUtils.getFilmsByYearAndMonth(cinema.getFilmsByYear(), 2021, Month.JUNE));
        System.out.println("\n_______________________________________________________________");
        System.out.println("\nTop 10 Films by Rating: " + CinemaUtils.getTop10FilmsByRating(cinema.getFilmsByYear()));
    }
}
