package com.dmdev.functional.utility;

import com.dmdev.functional.base.Report;
import com.dmdev.functional.base.Student;

import java.util.*;
import java.util.stream.Collectors;


public class StudentUtility {



    public static Map<Integer, List<String>> coursesAndSortedStudentLists(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFullName))
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        Collectors.mapping(Student::getFullName, Collectors.toList())
                ));
    }

    public static Map<Integer, Report> courseAndStudentNamesWithAverageGrade(
            Map<Integer, List<String>> sortedStudentList, List<Student> students, int minMarksCount) {
        Map<Integer, List<Student>> filteredByGradesCount = students.stream()
                .filter(s -> s.getGrades().size() > minMarksCount)
                .collect(Collectors.groupingBy(Student::getCourseNumber));

        return filteredByGradesCount.entrySet().stream()
                .collect(Collectors.toMap(
                        integerListEntry -> integerListEntry.getKey(),
                        entry -> {
                            List<String> studentNames = sortedStudentList.get(entry.getKey());
                            if (studentNames == null) {
                                studentNames = new ArrayList<>();
                            }
                            double averageGrade = entry.getValue().stream()
                                    .mapToDouble(s -> s.getAverageGrade(s.getGrades()))
                                    .average()
                                    .orElseGet(() -> 0.0);

                            return new Report(studentNames, averageGrade);
                        }
                ));
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


