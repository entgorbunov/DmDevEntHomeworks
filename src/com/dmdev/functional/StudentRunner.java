package com.dmdev.functional;

import com.dmdev.functional.base.Student;
import com.dmdev.functional.utility.StudentUtility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.dmdev.functional.utility.StudentUtility.printStudents;

public class StudentRunner {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Иван", "Иванов", 1, Arrays.asList(5, 4, 3, 5)),
                new Student("Петр", "Петров", 1, Arrays.asList(3, 4, 2)),
                new Student("Сидор", "Сидоров", 2, Arrays.asList(5, 5, 5, 5)),
                new Student("Николай", "Николаев", 2, Arrays.asList(4, 3, 5)),
                new Student("Мария", "Мариева", 3, Arrays.asList(5, 5, 5, 5, 5)),
                new Student("Анна", "Анова", 3, Arrays.asList(4, 4, 4, 4))
        );

        printStudents(StudentUtility.outputForStudents(students));
    }


}

