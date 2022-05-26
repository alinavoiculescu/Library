package repository;

import entity.BookEntity;
import mapper.BookEntityMapper;
import service.database.DatabaseConnectionService;
import service.database.QueryExecutorService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public static List<BookEntity> findAll() {

        List<Object> objects = QueryExecutorService.executeReadQuery("select * from book where subject is null", new BookEntityMapper());
        List<BookEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof BookEntity) {
                result.add((BookEntity) object);
            } else {
                throw new RuntimeException("Expected BookEntity instance");
            }
        }

        return result;
    }

    public static List<BookEntity> findAllForAuthor(Integer authorId) {
        List<Object> objects = QueryExecutorService.executeReadQuery("select * from book where subject is null and \"authorId\" = " + authorId, new BookEntityMapper());
        List<BookEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof BookEntity) {
                result.add((BookEntity) object);
            } else {
                throw new RuntimeException("Expected BookEntity instance");
            }
        }

        return result;
    }

    public static List<BookEntity> findAllForSection(Integer sectionId) {
        List<Object> objects = QueryExecutorService.executeReadQuery("select * from book where subject is null and \"sectionId\" = " + sectionId, new BookEntityMapper());
        List<BookEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof BookEntity) {
                result.add((BookEntity) object);
            } else {
                throw new RuntimeException("Expected BookEntity instance");
            }
        }

        return result;
    }

    public static BookEntity findBook(Long bookISBN) {
        BookEntity bookEntity = new BookEntity();
        try {
            PreparedStatement preparedStatement = DatabaseConnectionService.getDatabaseConnection().prepareStatement("select * from book where isbn = " + bookISBN);
            ResultSet resultSetBook = preparedStatement.executeQuery();
            resultSetBook.next();
            bookEntity.setIsbn(resultSetBook.getLong("isbn"));
            bookEntity.setTitle(resultSetBook.getString("title"));
            bookEntity.setNumberOfPages(resultSetBook.getInt("numberOfPages"));
            bookEntity.setPrice(resultSetBook.getFloat("price"));
            bookEntity.setAuthor(AuthorRepository.findAuthor(resultSetBook.getInt("authorId")));
            bookEntity.setSection(SectionRepository.findSection(resultSetBook.getInt("sectionId")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookEntity;
    }

    public static void addBook(BookEntity bookEntity) {

        QueryExecutorService.executeUpdateQuery("insert into book(isbn, title, \"authorId\", \"numberOfPages\", price, \"sectionId\") values(" + bookEntity.getIsbn() + ", '" + bookEntity.getTitle() + "', " + bookEntity.getAuthor().getId() + ", " + bookEntity.getNumberOfPages() + ", " + bookEntity.getPrice() + ", " + bookEntity.getSection().getId() + ")");
    }

    public static void deleteBook(String title) {

        QueryExecutorService.executeUpdateQuery("delete from book where subject is null and title = '" + title + "'");
    }

    public static void updateBooksTitle(String title, String newTitle) {

        QueryExecutorService.executeUpdateQuery("update book set title = '" + newTitle + "' where subject is null and title = '" + title + "'");
    }

    public static void updateBooksPrice(String title, Float newPrice) {

        QueryExecutorService.executeUpdateQuery("update book set price = " + newPrice + " where subject is null and title = '" + title + "'");
    }

    public static void updateBooksNumberOfPages(String title, Integer newNumberOfPages) {

        QueryExecutorService.executeUpdateQuery("update book set \"numberOfPages\" = " + newNumberOfPages + " where subject is null and title = '" + title + "'");
    }
}