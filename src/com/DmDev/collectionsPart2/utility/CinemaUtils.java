package com.DmDev.collectionsPart2.utility;

import com.DmDev.collectionsPart2.base.Film;

import java.util.*;

public class CinemaUtils {

    public static void addFilm(Map<Integer, List<Film>> filmsByYear, Film film) {
        List<Film> filmsForYear = filmsByYear.get(film.getYearOfRelease());
        if (filmsForYear == null) {
            filmsForYear = new ArrayList<>();
            filmsByYear.put(film.getYearOfRelease(), filmsForYear);
        }
        filmsForYear.add(film);
    }


    public static List<Film> getFilmsByYear(Map<Integer, List<Film>> filmsByYear, int year) {
        return filmsByYear.getOrDefault(year, Collections.emptyList());
    }

    public static List<Film> getFilmsByYearAndMonth(Map<Integer, List<Film>> filmsByYear, int year, int month) {
        List<Film> result = new ArrayList<>();
        List<Film> films = getFilmsByYear(filmsByYear, year);
        for (Film film : films) {
            if (film.getMonthOfRelease() == month) {
                result.add(film);
            }
        }
        return result;
    }

    public static List<Film> getFilmsByGenre(Map<Integer, List<Film>> filmsByYear, String genre) {
        List<Film> result = new ArrayList<>();
        for (List<Film> films : filmsByYear.values()) {
            for (Film film : films) {
                if (film.getGenre().equalsIgnoreCase(genre)) {
                    result.add(film);
                }
            }
        }
        return result;
    }

    public static List<Film> getTop10FilmsByRating(Map<Integer, List<Film>> filmsByYear) {
        List<Film> allFilms = new ArrayList<>();
        // Собираем все фильмы в один список
        for (List<Film> yearFilms : filmsByYear.values()) {
            allFilms.addAll(yearFilms);
        }

        Collections.sort(allFilms, new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                return Double.compare(f2.getRating(), f1.getRating());
            }
        });

        int endIndex = Math.min(allFilms.size(), 10);
        List<Film> top10Films = new ArrayList<>();
        for (int i = 0; i < endIndex; i++) {
            top10Films.add(allFilms.get(i));
        }
        return top10Films;
    }
}

