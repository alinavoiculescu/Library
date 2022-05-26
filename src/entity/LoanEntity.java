package entity;

import java.util.Date;

public class LoanEntity {
    private Date loanDate;
    private ReaderEntity loaner;
    private BookEntity loanedBookEntity;
    private Date returnDate;

    public LoanEntity() {
        this.loanDate = new Date(System.currentTimeMillis());
        this.loaner = new ReaderEntity();
        this.loanedBookEntity = new BookEntity();
        this.returnDate = new Date(System.currentTimeMillis());
    }

    public LoanEntity(ReaderEntity loaner, BookEntity loanedBookEntity, Date returnDate) {
        this.loanDate = new Date(System.currentTimeMillis());
        this.loaner = loaner;
        this.loanedBookEntity = loanedBookEntity;
        this.returnDate = returnDate;
    }

    public LoanEntity(Date loanDate, ReaderEntity loaner, BookEntity loanedBookEntity, Date returnDate) {
        this.loanDate = loanDate;
        this.loaner = loaner;
        this.loanedBookEntity = loanedBookEntity;
        this.returnDate = returnDate;
    }

    public LoanEntity(LoanEntity loanEntity) {
        this.loanDate = loanEntity.getLoanDate();
        this.loaner = loanEntity.getLoaner();
        this.loanedBookEntity = loanEntity.getLoanedBook();
        this.returnDate = loanEntity.getReturnDate();
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public ReaderEntity getLoaner() {
        return loaner;
    }

    public void setLoaner(ReaderEntity loaner) {
        this.loaner = loaner;
    }

    public BookEntity getLoanedBook() {
        return loanedBookEntity;
    }

    public void setLoanedBook(BookEntity loanedBookEntity) {
        this.loanedBookEntity = loanedBookEntity;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "\nLoanEntity: \nLoan Date: " + loanDate + "\nLoaner: " + loaner + "\nLoaned book: " + loanedBookEntity + "\nReturn date: " + returnDate + "\n";
    }
}
