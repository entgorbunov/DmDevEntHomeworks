package com.dmdev.functional.utility;

import com.dmdev.functional.base.Report;
import com.dmdev.functional.base.Student;

import java.util.*;
import java.util.stream.Collectors;


public class StudentUtility {


    public static Map<Integer, Report> generateReportForStudents(List<Student> students, int minMarksCount) {
        List<Student> filteredStudents = filterStudentsByGradesCount(students, minMarksCount);
        return groupStudentsByCourse(filteredStudents);
    }

    private static List<Student> filterStudentsByGradesCount(List<Student> students, int minMarksCount) {
        return students.stream()
                .filter(student -> student.getGrades().size() > minMarksCount)
                .collect(Collectors.toList());
    }


    private static Map<Integer, Report> groupStudentsByCourse(List<Student> filteredStudents) {
        Map<Integer, List<Student>> studentsByCourse = filteredStudents.stream()
                .collect(Collectors.groupingBy(Student::getCourseNumber));

        return studentsByCourse.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> createReportForGroup(entry.getValue())
                ));
    }


    private static Report createReportForGroup(List<Student> students) {
        List<String> studentNames = sortAndConvertStudentNames(students);
        double averageGrade = calculateAverageGradeForGroup(students);
        return new Report(studentNames, averageGrade);
    }


    private static List<String> sortAndConvertStudentNames(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFirstName)
                        .thenComparing(Student::getLastName))
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .collect(Collectors.toList());
    }


    private static double calculateAverageGradeForGroup(List<Student> students) {
        return students.stream()
                .flatMapToInt(student -> student.getGrades().stream().mapToInt(Integer::intValue))
                .average()
                .orElseGet(() -> 0.0);
    }



    public static void printStudents(Map<Integer, Report> processedStudents) {
        processedStudents.forEach((course, report) -> {
            System.out.println("Курс: " + course);
            System.out.println("Студенты: " + String.join(", ", report.getStudentNames()));
            System.out.println("Средняя оценка: " + report.getAverageGrade());
            System.out.println();
        });
    }
}


