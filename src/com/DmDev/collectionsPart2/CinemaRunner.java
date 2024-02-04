package com.DmDev.collectionsPart2;

public class CinemaRunner {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.addFilm(new Film(1, 2020, 5, "Action", 8.5));
        cinema.addFilm(new Film(2, 2020, 6, "Drama", 9.0));
        cinema.addFilm(new Film(3, 2021, 5, "Action", 7.5));
        cinema.addFilm(new Film(4, 2021, 6, "Comedy", 8.0));
        // Добавляем фильм с тем же ID, чтобы проверить предотвращение дубликатов
        cinema.addFilm(new Film(1, 2020, 5, "Action", 8.5));

        System.out.println("Films in 2020: " + cinema.getFilmsByYear(2020));
        System.out.println("Action films: " + cinema.getFilmsByGenre("Action"));
        System.out.println("Films in June 2021: " + cinema.getFilmsByYearAndMonth(2021, 6));
        System.out.println("Top 10 Films by Rating: " + cinema.getTop10FilmsByRating());
    }
}

