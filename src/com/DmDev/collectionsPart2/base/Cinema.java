package com.DmDev.collectionsPart2.base;

import java.util.*;

public class Cinema {
    private Map<Integer, List<Film>> filmsByYear;

    public Cinema() {
        this.filmsByYear = new TreeMap<>();
    }

    public Map<Integer, List<Film>> getFilmsByYear() {
        return filmsByYear;
    }

    public void setFilmsByYear(Map<Integer, List<Film>> filmsByYear) {
        this.filmsByYear = filmsByYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(filmsByYear, cinema.filmsByYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsByYear);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cinema{\n");
        for (Map.Entry<Integer, List<Film>> entry : filmsByYear.entrySet()) {
            sb.append("\tYear: ").append(entry.getKey()).append("\n");
            for (Film film : entry.getValue()) {
                sb.append("\t\t").append(film).append("\n");
            }
        }
        sb.append('}');
        return sb.toString();
    }

}

