package mapper;

import entity.AuthorEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorEntityMapper implements RowMapper<AuthorEntity> {

    @Override
    public AuthorEntity mapRow(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Integer age = resultSet.getInt("age");

        return new AuthorEntity(id, name, age);
    }
}
