package com.dmdev.functional.utility;

import com.dmdev.functional.base.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentUtility {

    public static TreeMap<Integer, Object> processStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    List<Student> sortedStudents = list.stream()
                                            .sorted(Comparator.comparing(Student::getFirstName)
                                                    .thenComparing(Student::getLastName))
                                            .toList();

                                    double averageGrade = list.stream()
                                            .filter(s -> s.getGrades().size() > 3)
                                            .flatMapToInt(s -> s.getGrades().stream().mapToInt(Integer::intValue))
                                            .average()
                                            .orElse(0);

                                    return new AbstractMap.SimpleEntry<>(
                                            sortedStudents.stream().map(s -> s.getFirstName() + " " + s.getLastName()).collect(Collectors.toList()),
                                            averageGrade
                                    );
                                }
                        )));
    }
}

