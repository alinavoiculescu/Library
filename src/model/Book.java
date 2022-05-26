package model;

import java.util.Objects;

public class Book {
    protected Long isbn;
    protected String title;
    protected Integer numberOfPages;
    protected Float price;

    public Book() {
        this.isbn = 0L;
        this.title = "Unknown title";
        this.numberOfPages = 0;
        this.price = 0f;
    }

    public Book(Long isbn, String title, Integer numberOfPages, Float price) {
        this.isbn = isbn;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nISBN: " + isbn + "\nTitle: " + title + "\nNumber of pages: " + numberOfPages + "\nPrice: " + price + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn) && title.equals(book.title) && numberOfPages.equals(book.numberOfPages) && price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, numberOfPages, price);
    }
}
