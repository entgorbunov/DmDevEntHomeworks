package com.dmdev.functional.utility;

import com.dmdev.functional.base.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;

public class StudentUtility {

    public static TreeMap<Integer, Map.Entry<List<String>, Double>> outputForStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                StudentUtility::createEntryFromStudentGroup
                        )));
    }

    private static Map.Entry<List<String>, Double> createEntryFromStudentGroup(List<Student> students) {
        List<Student> sortedStudents = sortStudentsByName(students);
        double averageGrade = calculateAverageGrade(students);
        return new SimpleEntry<>(
                convertToFullNameList(sortedStudents),
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
                .flatMapToInt(s -> s.getGrades()
                        .stream()
                        .mapToInt(Integer::intValue))
                .average()
                .orElse(0);
    }

    private static List<String> convertToFullNameList(List<Student> sortedStudents) {
        return sortedStudents.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.toList());
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

