package com.liuyi.learn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * StreamDistinct
 *
 * @author Eason Liu
 * Create at: 2023/7/10
 */
public class StreamDistinct {
    public static void main(String[] args) {

        Locale locale = new Locale("tl", "PH");
        System.out.println(locale);
        List<Student> students = Arrays.asList(
                new Student(1, "Eason", "Male"),
                new Student(2, "Lucy", "Female"),
                new Student(3, "Lucy", "Female")
        );

        // distinct by to equals&hashcode
        List<Student> result = students.stream().distinct().collect(Collectors.toList());
        System.out.println(result);

        // distinct by filter
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        result = students.stream()
                .filter(student -> seen.add(student.getName()))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static class Student {
        private int id;
        private String name;
        private String sex;

        public Student(int id, String name, String sex) {
            this.id = id;
            this.name = name;
            this.sex = sex;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSex() {
            return sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return Objects.equals(name, student.name) && Objects.equals(sex, student.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, sex);
        }
    }
}
