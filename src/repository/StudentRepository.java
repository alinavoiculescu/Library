package repository;

import entity.StudentEntity;
import mapper.StudentEntityMapper;
import service.database.QueryExecutorService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public static ArrayList<StudentEntity> findAll() {

        ArrayList<Object> objects = (ArrayList<Object>) QueryExecutorService.executeReadQuery("select * from reader where university is not null", new StudentEntityMapper());
        ArrayList<StudentEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof StudentEntity) {
                result.add((StudentEntity) object);
            } else {
                throw new RuntimeException("Expected StudentEntity instance");
            }
        }

        return result;
    }

    public static void addStudent(StudentEntity studentEntity) {

        Date registerDate = new Date(studentEntity.getRegisterDate().getTime());

        QueryExecutorService.executeUpdateQuery("insert into reader values(" + studentEntity.getId() + ", '" + studentEntity.getName() + "', TO_DATE('" + registerDate + "', 'YYYY-MM-DD HH:MI:SS'), '" + studentEntity.getUniversity() + "', " + studentEntity.getYear() + ", " + studentEntity.getAge() + ")");
    }

    public static void deleteStudent(String name) {

        QueryExecutorService.executeUpdateQuery("delete from reader where university is not null and name = '" + name + "'");
    }

    public static void updateStudentsName(String name, String newName) {

        QueryExecutorService.executeUpdateQuery("update reader set name = '" + newName + "' where university is not null and name = '" + name + "'");
    }

    public static void updateStudentsAge(String name, Integer newAge) {

        QueryExecutorService.executeUpdateQuery("update reader set age = " + newAge + " where university is not null and name = '" + name + "'");
    }

    public static void updateStudentsUniversity(String name, String newUniversity) {

        QueryExecutorService.executeUpdateQuery("update reader set university = '" + newUniversity + "' where university is not null and name = '" + name + "'");
    }

    public static void updateStudentsYear(String name, Integer newYear) {

        QueryExecutorService.executeUpdateQuery("update reader set year = " + newYear + " where university is not null and name = '" + name + "'");
    }
}
