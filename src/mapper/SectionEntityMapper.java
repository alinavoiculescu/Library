package mapper;

import entity.SectionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionEntityMapper implements RowMapper<SectionEntity> {

    @Override
    public SectionEntity mapRow(ResultSet resultSet) throws SQLException {

        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new SectionEntity(id, name);
    }
}
