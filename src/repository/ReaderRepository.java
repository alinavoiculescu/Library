package repository;

import entity.ReaderEntity;
import mapper.ReaderEntityMapper;
import service.database.DatabaseConnectionService;
import service.database.QueryExecutorService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReaderRepository {

    public static ArrayList<ReaderEntity> findAll() {

        ArrayList<Object> objects = (ArrayList<Object>) QueryExecutorService.executeReadQuery("select * from reader where university is null", new ReaderEntityMapper());
        ArrayList<ReaderEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof ReaderEntity) {
                result.add((ReaderEntity) object);
            } else {
                throw new RuntimeException("Expected ReaderEntity instance");
            }
        }

        return result;
    }

    public static ReaderEntity findReader(Integer readerId) {

        ReaderEntity readerEntity = new ReaderEntity();
        try {
            PreparedStatement preparedStatement = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from reader where id = " + readerId);
            ResultSet resultSetReader = preparedStatement.executeQuery();
            resultSetReader.next();
            readerEntity.setId(resultSetReader.getInt("id"));
            readerEntity.setName(resultSetReader.getString("name"));
            readerEntity.setAge(resultSetReader.getInt("age"));
            readerEntity.setRegisterDate(resultSetReader.getDate("registerDate"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return readerEntity;
    }

    public static void addReader(ReaderEntity readerEntity) {

        Date registerDate = new Date(readerEntity.getRegisterDate().getTime());

        QueryExecutorService.executeUpdateQuery("insert into reader(id, name, \"registerDate\", age) values(" + readerEntity.getId() + ", '" + readerEntity.getName() + "', TO_DATE('" + registerDate + "', 'YYYY-MM-DD HH:MI:SS'), " + readerEntity.getAge() + ")");
    }

    public static void deleteReader(String name) {

        QueryExecutorService.executeUpdateQuery("delete from reader where university is null and name = '" + name + "'");
    }

    public static void updateReadersName(String name, String newName) {

        QueryExecutorService.executeUpdateQuery("update reader set name = '" + newName + "' where university is null and name = '" + name + "'");
    }

    public static void updateReadersAge(String name, Integer newAge) {

        QueryExecutorService.executeUpdateQuery("update reader set age = " + newAge + " where university is null and name = '" + name + "'");
    }
}
