package mapper;

import entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StudentEntityMapper implements RowMapper<StudentEntity> {

    @Override
    public StudentEntity mapRow(ResultSet resultSet) throws SQLException {

        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Integer age = resultSet.getInt("age");
        Date registerDate = resultSet.getDate("registerDate");
        String university = resultSet.getString("university");
        Integer year = resultSet.getInt("year");

        return new StudentEntity(id, name, age, registerDate, university, year);
    }
}