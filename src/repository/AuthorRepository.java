package repository;

import entity.AuthorEntity;
import mapper.AuthorEntityMapper;
import service.database.DatabaseConnectionService;
import service.database.QueryExecutorService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    public static List<AuthorEntity> findAll() {

        List<Object> objects = QueryExecutorService.executeReadQuery("select * from author", new AuthorEntityMapper());
        List<AuthorEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof AuthorEntity) {
                result.add((AuthorEntity) object);
            } else {
                throw new RuntimeException("Expected AuthorEntity instance");
            }
        }

        return result;
    }

    public static AuthorEntity findAuthor(Integer authorId) {
        AuthorEntity authorEntity = new AuthorEntity();
        try {
            PreparedStatement preparedStatement = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from author where id = " + authorId);
            ResultSet resultSetAuthor = preparedStatement.executeQuery();
            resultSetAuthor.next();
            authorEntity.setId(resultSetAuthor.getInt("id"));
            authorEntity.setName(resultSetAuthor.getString("name"));
            authorEntity.setAge(resultSetAuthor.getInt("age"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authorEntity;
    }

    public static void addAuthor(AuthorEntity authorEntity) {

        QueryExecutorService.executeUpdateQuery("insert into author values(" + authorEntity.getId() + ", '" + authorEntity.getName() + "', " + authorEntity.getAge() + ")");
    }

    public static void deleteAuthor(String name) {

        QueryExecutorService.executeUpdateQuery("delete from author where name = '" + name + "'");
    }

    public static void updateAuthorsName(String name, String newName) {

        QueryExecutorService.executeUpdateQuery("update author set name = '" + newName + "' where name = '" + name + "'");
    }

    public static void updateAuthorsAge(String name, Integer newAge) {

        QueryExecutorService.executeUpdateQuery("update author set age = " + newAge + " where name = '" + name + "'");
    }
}
