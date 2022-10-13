package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иван Иванович Иванов");
        student.setGroup("К-12");
        student.setDate(LocalDate.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        System.out.println(student.getName() + " учится в группе " + student.getGroup() + " с " + student.getDate().format(formatter));
    }
}
