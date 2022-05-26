package repository;

import entity.TextBookEntity;
import mapper.TextBookEntityMapper;
import service.database.QueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class TextBookRepository {

    public static List<TextBookEntity> findAll() {

        List<Object> objects = QueryExecutorService.executeReadQuery("select * from book where subject is not null", new TextBookEntityMapper());
        List<TextBookEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof TextBookEntity) {
                result.add((TextBookEntity) object);
            } else {
                throw new RuntimeException("Expected TextBookEntity instance");
            }
        }

        return result;
    }

    public static List<TextBookEntity> findAllForAuthor(Integer authorId) {
        List<Object> objects = QueryExecutorService.executeReadQuery("select * from book where subject is not null and \"authorId\" = " + authorId, new TextBookEntityMapper());
        List<TextBookEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof TextBookEntity) {
                result.add((TextBookEntity) object);
            } else {
                throw new RuntimeException("Expected TextBookEntity instance");
            }
        }

        return result;
    }

    public static List<TextBookEntity> findAllForSection(Integer sectionId) {
        List<Object> objects = QueryExecutorService.executeReadQuery("select * from book where subject is not null and sectionId = " + sectionId, new TextBookEntityMapper());
        List<TextBookEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof TextBookEntity) {
                result.add((TextBookEntity) object);
            } else {
                throw new RuntimeException("Expected TextBookEntity instance");
            }
        }

        return result;
    }

    public static void addTextBook(TextBookEntity textBookEntity) {

        QueryExecutorService.executeUpdateQuery("insert into book values(" + textBookEntity.getIsbn() + ", '" + textBookEntity.getTitle() + "', " + textBookEntity.getAuthor().getId() + ", " + textBookEntity.getNumberOfPages() + ", " + textBookEntity.getPrice() + ", " + textBookEntity.getSection().getId() + ", '" + textBookEntity.getSubject() + "')");
    }

    public static void deleteTextBook(String title) {

        QueryExecutorService.executeUpdateQuery("delete from book where subject is not null and title = '" + title + "'");
    }

    public static void updateTextBooksTitle(String title, String newTitle) {

        QueryExecutorService.executeUpdateQuery("update book set title = '" + newTitle + "' where subject is not null and title = '" + title + "'");
    }

    public static void updateTextBooksPrice(String title, Float newPrice) {

        QueryExecutorService.executeUpdateQuery("update book set price = " + newPrice + " where subject is not null and title = '" + title + "'");
    }

    public static void updateTextBooksNumberOfPages(String title, Integer newNumberOfPages) {

        QueryExecutorService.executeUpdateQuery("update book set \"numberOfPages\" = " + newNumberOfPages + " where subject is not null and title = '" + title + "'");
    }

    public static void updateTextBooksSubject(String title, String newSubject) {

        QueryExecutorService.executeUpdateQuery("update book set subject = '" + newSubject + "' where subject is not null and title = '" + title + "'");
    }
}
