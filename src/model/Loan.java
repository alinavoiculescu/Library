package model;

import java.util.Date;

public class Loan {
    private Date loanDate;
    private Date returnDate;

    public Loan() {
        this.loanDate = new Date(System.currentTimeMillis());
        this.returnDate = new Date(System.currentTimeMillis());
    }

    public Loan(Date returnDate) {
        this.loanDate = new Date(System.currentTimeMillis());
        this.returnDate = returnDate;
    }

    public Loan(Date loanDate, Date returnDate) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loan(Loan loan) {
        this.loanDate = loan.getLoanDate();
        this.returnDate = loan.getReturnDate();
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "\nLoan Date: " + loanDate + "\nReturn date: " + returnDate + "\n";
    }
}
