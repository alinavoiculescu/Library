package service;

import entity.StudentEntity;
import model.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public static ArrayList<Student> getAllStudents() {

        ArrayList<StudentEntity> studentEntities = StudentRepository.findAll();
        ArrayList<Student> result = new ArrayList<>();

        for (StudentEntity studentEntity : studentEntities) {
            result.add(new Student(studentEntity.getId(), studentEntity.getName(), studentEntity.getAge(), studentEntity.getRegisterDate(), studentEntity.getUniversity(), studentEntity.getYear()));
        }

        return result;
    }


    public static void addStudent(Student student) {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setRegisterDate(student.getRegisterDate());
        studentEntity.setUniversity(student.getUniversity());
        studentEntity.setYear(student.getYear());

        StudentRepository.addStudent(studentEntity);
    }

    public static void deleteStudent(String name) {

        StudentRepository.deleteStudent(name);
    }

    public static void updateStudentsName(String name, String newName) {

        StudentRepository.updateStudentsName(name, newName);
    }

    public static void updateStudentsAge(String name, Integer newAge) {

        StudentRepository.updateStudentsAge(name, newAge);
    }

    public static void updateStudentsUniversity(String name, String newUniversity) {

        StudentRepository.updateStudentsUniversity(name, newUniversity);
    }

    public static void updateStudentsYear(String name, Integer newYear) {

        StudentRepository.updateStudentsYear(name, newYear);
    }
}
