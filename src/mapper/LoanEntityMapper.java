package mapper;

import entity.*;
import service.database.DatabaseConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LoanEntityMapper implements RowMapper<LoanEntity> {

    private static final Connection connection;

    static {
        try {
            connection = DatabaseConnectionService.getDatabaseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LoanEntity mapRow(ResultSet resultSet) throws SQLException {
        Date loanDate = resultSet.getDate("loanDate");
        Date returnDate = resultSet.getDate("returnDate");
        long bookISBN = resultSet.getLong("bookISBN");
        int readerId = resultSet.getInt("readerId");

        BookEntity bookEntity = null;
        TextBookEntity textBookEntity = null;

        try {
            PreparedStatement preparedStatement = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from book where isbn = " + bookISBN);
            ResultSet resultSetBook = preparedStatement.executeQuery();
            resultSetBook.next();

            if (resultSetBook.getString("subject") == null) {
                bookEntity = new BookEntity();
                bookEntity.setIsbn(resultSetBook.getLong("isbn"));
                bookEntity.setTitle(resultSetBook.getString("title"));
                bookEntity.setNumberOfPages(resultSetBook.getInt("numberOfPages"));
                bookEntity.setPrice(resultSetBook.getFloat("price"));

                AuthorEntity authorEntity = new AuthorEntity();
                Integer authorId = resultSetBook.getInt("authorId");
                try {
                    PreparedStatement preparedStatementAuthor = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from author where id = " + authorId);
                    ResultSet resultSetAuthor = preparedStatementAuthor.executeQuery();
                    resultSetAuthor.next();
                    authorEntity.setId(authorId);
                    authorEntity.setName(resultSetAuthor.getString("name"));
                    authorEntity.setAge(resultSetAuthor.getInt("age"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                bookEntity.setAuthor(authorEntity);

                SectionEntity sectionEntity = new SectionEntity();
                Integer sectionId = resultSetBook.getInt("sectionId");
                try {
                    PreparedStatement preparedStatementSection = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from section where id = " + sectionId);
                    ResultSet resultSetSection = preparedStatementSection.executeQuery();
                    resultSetSection.next();
                    sectionEntity.setId(sectionId);
                    sectionEntity.setName(resultSetSection.getString("name"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                bookEntity.setSection(sectionEntity);
            } else {
                textBookEntity = new TextBookEntity();
                textBookEntity.setIsbn(resultSetBook.getLong("isbn"));
                textBookEntity.setTitle(resultSetBook.getString("title"));
                textBookEntity.setNumberOfPages(resultSetBook.getInt("numberOfPages"));
                textBookEntity.setPrice(resultSetBook.getFloat("price"));

                AuthorEntity authorEntity = new AuthorEntity();
                Integer authorId = resultSetBook.getInt("authorId");
                try {
                    PreparedStatement preparedStatementAuthor = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from author where id = " + authorId);
                    ResultSet resultSetAuthor = preparedStatementAuthor.executeQuery();
                    resultSetAuthor.next();
                    authorEntity.setId(authorId);
                    authorEntity.setName(resultSetAuthor.getString("name"));
                    authorEntity.setAge(resultSetAuthor.getInt("age"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                textBookEntity.setAuthor(authorEntity);

                SectionEntity sectionEntity = new SectionEntity();
                Integer sectionId = resultSetBook.getInt("sectionId");
                try {
                    PreparedStatement preparedStatementSection = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from section where id = " + sectionId);
                    ResultSet resultSetSection = preparedStatementSection.executeQuery();
                    resultSetSection.next();
                    sectionEntity.setId(sectionId);
                    sectionEntity.setName(resultSetSection.getString("name"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                textBookEntity.setSection(sectionEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ReaderEntity readerEntity = null;
        StudentEntity studentEntity = null;

        try {
            PreparedStatement preparedStatement = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from reader where id = " + readerId);
            ResultSet resultSetReader = preparedStatement.executeQuery();
            resultSetReader.next();

            if (resultSetReader.getString("university") == null) {
                readerEntity = new ReaderEntity();
                readerEntity.setId(resultSetReader.getInt("id"));
                readerEntity.setName(resultSetReader.getString("name"));
                readerEntity.setAge(resultSetReader.getInt("age"));
            } else {
                studentEntity = new StudentEntity();
                studentEntity.setId(resultSetReader.getInt("id"));
                studentEntity.setName(resultSetReader.getString("name"));
                studentEntity.setAge(resultSetReader.getInt("age"));
                studentEntity.setUniversity(resultSetReader.getString("university"));
                studentEntity.setYear(resultSetReader.getInt("year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (bookEntity == null) {
            if (readerEntity == null) {
                return new LoanEntity(loanDate, studentEntity, textBookEntity, returnDate);
            }

            return new LoanEntity(loanDate, readerEntity, textBookEntity, returnDate);
        } else {
            if (readerEntity == null) {
                return new LoanEntity(loanDate, studentEntity, bookEntity, returnDate);
            }

            return new LoanEntity(loanDate, readerEntity, bookEntity, returnDate);
        }
    }
}
