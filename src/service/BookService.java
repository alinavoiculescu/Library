package service;

import entity.BookEntity;
import model.Book;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.SectionRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static List<Book> getAllBooks() {

        List<BookEntity> bookEntities = BookRepository.findAll();
        List<Book> result = new ArrayList<>();

        for (BookEntity bookEntity : bookEntities) {
            result.add(new Book(bookEntity.getIsbn(), bookEntity.getTitle(), bookEntity.getNumberOfPages(), bookEntity.getPrice()));
        }

        return result;
    }

    public static List<Book> getAllBooksForAuthor(Integer authorId) {

        List<BookEntity> bookEntities = BookRepository.findAllForAuthor(authorId);
        List<Book> result = new ArrayList<>();

        for (BookEntity bookEntity : bookEntities) {
            result.add(new Book(bookEntity.getIsbn(), bookEntity.getTitle(), bookEntity.getNumberOfPages(), bookEntity.getPrice()));
        }

        return result;
    }

    public static List<Book> getAllBooksForSection(Integer sectionId) {

        List<BookEntity> bookEntities = BookRepository.findAllForSection(sectionId);
        List<Book> result = new ArrayList<>();

        for (BookEntity bookEntity : bookEntities) {
            result.add(new Book(bookEntity.getIsbn(), bookEntity.getTitle(), bookEntity.getNumberOfPages(), bookEntity.getPrice()));
        }

        return result;
    }

    public static Book getBook(Long bookISBN) {

        BookEntity bookEntity = BookRepository.findBook(bookISBN);

        return new Book(bookEntity.getIsbn(), bookEntity.getTitle(), bookEntity.getNumberOfPages(), bookEntity.getPrice());
    }

    public static void addBook(Book book, Integer authorId, Integer sectionId) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setNumberOfPages(book.getNumberOfPages());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setAuthor(AuthorRepository.findAuthor(authorId));
        bookEntity.setSection(SectionRepository.findSection(sectionId));

        BookRepository.addBook(bookEntity);
    }

    public static void deleteBook(String title) {

        BookRepository.deleteBook(title);
    }

    public static void updateBooksTitle(String title, String newTitle) {

        BookRepository.updateBooksTitle(title, newTitle);
    }

    public static void updateBooksPrice(String title, Float newPrice) {

        BookRepository.updateBooksPrice(title, newPrice);
    }

    public static void updateBooksNumberOfPages(String title, Integer newNumberOfPages) {

        BookRepository.updateBooksNumberOfPages(title, newNumberOfPages);
    }
}
