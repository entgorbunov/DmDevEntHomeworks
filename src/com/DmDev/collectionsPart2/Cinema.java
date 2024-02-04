package com.DmDev.collectionsPart2;

import java.util.*;

public class Cinema {
    private Map<Integer, List<Film>> filmsByYear;

    public Cinema() {
        this.filmsByYear = new TreeMap<>();
    }

    public void addFilm(Film film) {

        List<Film> filmsForYear = filmsByYear.computeIfAbsent(film.getYearOfRelease(), k -> new ArrayList<>());

        boolean filmExists = false;

        for (Film existingFilm : filmsForYear) {
            if (existingFilm.getId() == film.getId()) {
                filmExists = true;
                break;
            }
        }

        if (!filmExists) {
            filmsForYear.add(film);
        }
    }


    public List<Film> getFilmsByYear(int year) {
        return filmsByYear.getOrDefault(year, Collections.emptyList());
    }

    public List<Film> getFilmsByYearAndMonth(int year, int month) {
        List<Film> films = getFilmsByYear(year);
        List<Film> result = new ArrayList<>();
        for (Film film : films) {
            if (film.getMonthOfRelease() == month) {
                result.add(film);
            }
        }
        return result;
    }

    public List<Film> getFilmsByGenre(String genre) {
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

    public List<Film> getTop10FilmsByRating() {
        List<Film> allFilms = new ArrayList<>();
        // Собираем все фильмы в один список
        for (List<Film> yearFilms : filmsByYear.values()) {
            for (Film film : yearFilms) {
                allFilms.add(film);
            }
        }
        Collections.sort(allFilms, new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                // Для сортировки по убыванию меняем местами f1 и f2
                return Double.compare(f2.getRating(), f1.getRating());
            }
        });
        // Возвращаем первые 10 фильмов, если их количество больше 10 или возвращаем весь список
        int end = Math.min(allFilms.size(), 10);
        return new ArrayList<>(allFilms.subList(0, end));
    }

}

