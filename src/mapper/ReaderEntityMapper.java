package mapper;

import entity.ReaderEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ReaderEntityMapper implements RowMapper<ReaderEntity> {

    @Override
    public ReaderEntity mapRow(ResultSet resultSet) throws SQLException {

        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Integer age = resultSet.getInt("age");
        Date registerDate = resultSet.getDate("registerDate");

        return new ReaderEntity(id, name, age, registerDate);
    }
}
