package com.dmdev.functional.base;

import java.util.List;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private Integer courseNumber;
    private List<Integer> grades;

    public Student(String firstName, String lastName, Integer courseNumber, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
        this.grades = grades;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public List<Integer> getGrades() {
        return grades;
    }


    @Override
    public String toString() {
        return "Student{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", courseNumber=" + courseNumber +
               ", grades=" + grades +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(courseNumber, student.courseNumber) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, courseNumber, grades);
    }

    public double getAverageGrade(List<Integer> grades) {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseGet(() -> 0.0);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}

