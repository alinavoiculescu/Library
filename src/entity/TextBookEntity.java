package entity;

public class TextBookEntity extends BookEntity {
    private String subject;

    public TextBookEntity() {
        super(0L, "Unknown Title", new AuthorEntity(), 0, 0f, new SectionEntity());
    }

    public TextBookEntity(Long isbn, String title, AuthorEntity authorEntity, Integer numberOfPages, Float price, SectionEntity sectionEntity, String subject) {
        super(isbn, title, authorEntity, numberOfPages, price, sectionEntity);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "\nTextBookEntity: \nISBN: " + isbn + "\nTitle: " + title + "\nAuthor: " + authorEntity + "\nNumber of pages: " + numberOfPages + "\nPrice: " + price + "\nSection: " + sectionEntity + "\nSubject: " + subject + "\n";
    }
}
