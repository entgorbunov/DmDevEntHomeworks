package com.dmdev.functional.utility;

import com.dmdev.functional.base.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentUtility {

    public static TreeMap<Integer, Map.Entry<List<String>, Double>> processStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                StudentUtility::processStudentGroup
                        )));
    }


    private static Map.Entry<List<String>, Double> processStudentGroup(List<Student> students) {
        List<Student> sortedStudents = sortStudentsByName(students);
        double averageGrade = calculateAverageGrade(students);
        return new AbstractMap.SimpleEntry<>(
                sortedStudents.stream()
                        .map(s -> s.getFirstName() + " " + s.getLastName())
                        .collect(Collectors.toList()),
                averageGrade
        );
    }

    private static List<Student> sortStudentsByName(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFirstName)
                        .thenComparing(Student::getLastName))
                .collect(Collectors.toList());
    }

    private static double calculateAverageGrade(List<Student> students) {
        return students.stream()
                .filter(s -> s.getGrades().size() > 3)
                .flatMapToInt(s -> s.getGrades().stream().mapToInt(Integer::intValue))
                .average()
                .orElse(0);
    }

    public static void printStudents(TreeMap<Integer, Map.Entry<List<String>, Double>> processedStudents) {
        processedStudents.forEach((course, entry) -> {
            System.out.println("Курс: " + course);
            System.out.println("Студенты: " + entry.getKey());
            System.out.println("Средняя оценка: " + entry.getValue());
            System.out.println();
        });
    }

}
