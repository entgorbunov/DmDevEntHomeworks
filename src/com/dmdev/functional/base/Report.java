package com.dmdev.functional.base;

import java.util.List;

public class Report {
    private final List<String> studentNames;
    private final double averageGrade;

    public Report(List<String> studentNames, double averageGrade) {
        this.studentNames = studentNames;
        this.averageGrade = averageGrade;
    }

    // Геттеры
    public List<String> getStudentNames() {
        return studentNames;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Report{" +
               "studentNames=" + studentNames +
               ", averageGrade=" + averageGrade +
               '}';
    }
}

