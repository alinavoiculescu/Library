package service;

import entity.TextBookEntity;
import model.TextBook;
import repository.AuthorRepository;
import repository.SectionRepository;
import repository.TextBookRepository;

import java.util.ArrayList;
import java.util.List;

public class TextBookService {

    public static List<TextBook> getAllTextBooks() {

        List<TextBookEntity> textBookEntities = TextBookRepository.findAll();
        List<TextBook> result = new ArrayList<>();

        for (TextBookEntity textBookEntity : textBookEntities) {
            result.add(new TextBook(textBookEntity.getIsbn(), textBookEntity.getTitle(), textBookEntity.getNumberOfPages(), textBookEntity.getPrice(), textBookEntity.getSubject()));
        }

        return result;
    }

    public static List<TextBook> getAllTextBooksForAuthor(Integer authorId) {

        List<TextBookEntity> textBookEntities = TextBookRepository.findAllForAuthor(authorId);
        List<TextBook> result = new ArrayList<>();

        for (TextBookEntity textBookEntity : textBookEntities) {
            result.add(new TextBook(textBookEntity.getIsbn(), textBookEntity.getTitle(), textBookEntity.getNumberOfPages(), textBookEntity.getPrice(), textBookEntity.getSubject()));
        }

        return result;
    }

    public static List<TextBook> getAllTextBooksForSection(Integer sectionId) {

        List<TextBookEntity> textBookEntities = TextBookRepository.findAllForSection(sectionId);
        List<TextBook> result = new ArrayList<>();

        for (TextBookEntity textBookEntity : textBookEntities) {
            result.add(new TextBook(textBookEntity.getIsbn(), textBookEntity.getTitle(), textBookEntity.getNumberOfPages(), textBookEntity.getPrice(), textBookEntity.getSubject()));
        }

        return result;
    }

    public static void addTextBook(TextBook textBook, Integer authorId, Integer sectionId) {

        TextBookEntity textBookEntity = new TextBookEntity();
        textBookEntity.setIsbn(textBook.getIsbn());
        textBookEntity.setTitle(textBook.getTitle());
        textBookEntity.setNumberOfPages(textBook.getNumberOfPages());
        textBookEntity.setPrice(textBook.getPrice());
        textBookEntity.setAuthor(AuthorRepository.findAuthor(authorId));
        textBookEntity.setSection(SectionRepository.findSection(sectionId));
        textBookEntity.setSubject(textBook.getSubject());

        TextBookRepository.addTextBook(textBookEntity);
    }

    public static void deleteTextBook(String title) {

        TextBookRepository.deleteTextBook(title);
    }

    public static void updateTextBooksTitle(String title, String newTitle) {

        TextBookRepository.updateTextBooksTitle(title, newTitle);
    }

    public static void updateTextBooksPrice(String title, Float newPrice) {

        TextBookRepository.updateTextBooksPrice(title, newPrice);
    }

    public static void updateTextBooksNumberOfPages(String title, Integer newNumberOfPages) {

        TextBookRepository.updateTextBooksNumberOfPages(title, newNumberOfPages);
    }

    public static void updateTextBooksSubject(String title, String newSubject) {

        TextBookRepository.updateTextBooksSubject(title, newSubject);
    }
}
