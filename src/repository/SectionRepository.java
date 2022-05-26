package repository;

import entity.SectionEntity;
import mapper.SectionEntityMapper;
import service.database.DatabaseConnectionService;
import service.database.QueryExecutorService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    public static List<SectionEntity> findAll() {

        List<Object> objects = QueryExecutorService.executeReadQuery("select * from section", new SectionEntityMapper());
        List<SectionEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof SectionEntity) {
                result.add((SectionEntity) object);
            } else {
                throw new RuntimeException("Expected SectionEntity instance");
            }
        }

        return result;
    }

    public static void addSection(SectionEntity sectionEntity) {

        QueryExecutorService.executeUpdateQuery("insert into section values(" + sectionEntity.getId() + ", '" + sectionEntity.getName() + "')");
    }

    public static SectionEntity findSection(Integer sectionId) {
        SectionEntity sectionEntity = new SectionEntity();
        try {
            PreparedStatement preparedStatement = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from section where id = " + sectionId);
            ResultSet resultSetSection = preparedStatement.executeQuery();
            resultSetSection.next();
            sectionEntity.setId(resultSetSection.getInt("id"));
            sectionEntity.setName(resultSetSection.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sectionEntity;
    }

    public static void deleteSection(String name) {

        QueryExecutorService.executeUpdateQuery("delete from section where name = '" + name + "'");
    }
}
