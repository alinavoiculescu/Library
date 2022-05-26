package model;

public class TextBook extends Book {
    private String subject;

    public TextBook() {
        super(0L, "Unknown Title", 0, 0f);
    }

    public TextBook(Long isbn, String title, Integer numberOfPages, Float price, String subject) {
        super(isbn, title, numberOfPages, price);
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
        return "\nISBN: " + isbn + "\nTitle: " + title + "\nNumber of pages: " + numberOfPages + "\nPrice: " + price + "\nSubject: " + subject + "\n";
    }
}
