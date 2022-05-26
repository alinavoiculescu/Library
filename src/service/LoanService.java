package service;

import entity.LoanEntity;
import model.Loan;
import repository.BookRepository;
import repository.LoanRepository;
import repository.ReaderRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanService {

    public static List<Loan> getAllLoans() {

        List<LoanEntity> loanEntities = LoanRepository.findAll();
        List<Loan> result = new ArrayList<>();

        for (LoanEntity loanEntity : loanEntities) {
            result.add(new Loan(loanEntity.getLoanDate(), loanEntity.getReturnDate()));
        }

        return result;
    }

    public static List<Loan> getAllLoansForBook(Long bookISBN) {

        List<LoanEntity> loanEntities = LoanRepository.findAllForBook(bookISBN);
        List<Loan> result = new ArrayList<>();

        for (LoanEntity loanEntity : loanEntities) {
            result.add(new Loan(loanEntity.getLoanDate(), loanEntity.getReturnDate()));
        }

        return result;
    }

    public static List<Loan> getAllLoansForReader(Integer readerId) {

        List<LoanEntity> loanEntities = LoanRepository.findAllForReader(readerId);
        List<Loan> result = new ArrayList<>();

        for (LoanEntity loanEntity : loanEntities) {
            result.add(new Loan(loanEntity.getLoanDate(), loanEntity.getReturnDate()));
        }

        return result;
    }

    public static void addLoan(Loan loan, Integer readerId, Long bookISBN) {

        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setLoanDate(loan.getLoanDate());
        loanEntity.setReturnDate(loan.getReturnDate());
        loanEntity.setLoaner(ReaderRepository.findReader(readerId));
        loanEntity.setLoanedBook(BookRepository.findBook(bookISBN));

        LoanRepository.addLoan(loanEntity);
    }

    public static void deleteLoan(Date loanDate, Date returnDate, Integer readerId) {

        LoanRepository.deleteLoan(loanDate, returnDate, readerId);
    }
}
