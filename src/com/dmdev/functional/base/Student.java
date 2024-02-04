package com.dmdev.functional.base;

import java.util.List;

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
}

