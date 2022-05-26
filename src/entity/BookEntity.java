package entity;

import java.util.Objects;

public class BookEntity {
    protected Long isbn;
    protected String title;
    protected AuthorEntity authorEntity;
    protected Integer numberOfPages;
    protected Float price;
    protected SectionEntity sectionEntity;

    public BookEntity() {
        this.isbn = 0L;
        this.title = "Unknown title";
        this.authorEntity = new AuthorEntity();
        this.numberOfPages = 0;
        this.price = 0f;
        this.sectionEntity = new SectionEntity();
    }

    public BookEntity(Long isbn, String title, AuthorEntity authorEntity, Integer numberOfPages, Float price, SectionEntity sectionEntity) {
        this.isbn = isbn;
        this.title = title;
        this.authorEntity = authorEntity;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.sectionEntity = sectionEntity;
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

    public AuthorEntity getAuthor() {
        return authorEntity;
    }

    public void setAuthor(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
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

    public SectionEntity getSection() {
        return sectionEntity;
    }

    public void setSection(SectionEntity sectionEntity) {
        this.sectionEntity = sectionEntity;
    }

    @Override
    public String toString() {
        return "\nBookEntity: \nISBN: " + isbn + "\nTitle: " + title + "\nAuthor: " + authorEntity + "\nNumber of pages: " + numberOfPages + "\nPrice: " + price + "\nSection: " + sectionEntity + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity bookEntity = (BookEntity) o;
        return isbn.equals(bookEntity.isbn) && title.equals(bookEntity.title) && authorEntity.equals(bookEntity.authorEntity) && numberOfPages.equals(bookEntity.numberOfPages) && price.equals(bookEntity.price) && sectionEntity.equals(bookEntity.sectionEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, authorEntity, numberOfPages, price, sectionEntity);
    }
}
