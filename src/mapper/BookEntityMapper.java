package mapper;

import entity.AuthorEntity;
import entity.BookEntity;
import entity.SectionEntity;
import service.database.DatabaseConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookEntityMapper implements RowMapper<BookEntity> {

    private static final Connection connection;

    static {
        try {
            connection = DatabaseConnectionService.getDatabaseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookEntity mapRow(ResultSet resultSet) throws SQLException {
        Long isbn = resultSet.getLong("isbn");
        String title = resultSet.getString("title");
        int authorId = resultSet.getInt("authorId");
        Integer numberOfPages = resultSet.getInt("numberOfPages");
        Float price = resultSet.getFloat("price");
        int sectionId = resultSet.getInt("sectionId");

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

        return new BookEntity(isbn, title, authorEntity, numberOfPages, price, sectionEntity);
    }
}
