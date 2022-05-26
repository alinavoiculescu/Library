package repository;

import entity.LoanEntity;
import mapper.LoanEntityMapper;
import service.database.QueryExecutorService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {

    public static List<LoanEntity> findAll() {

        List<Object> objects = QueryExecutorService.executeReadQuery("select * from loan", new LoanEntityMapper());
        List<LoanEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof LoanEntity) {
                result.add((LoanEntity) object);
            } else {
                throw new RuntimeException("Expected LoanEntity instance");
            }
        }

        return result;
    }

    public static List<LoanEntity> findAllForBook(Long bookISBN) {

        List<Object> objects = QueryExecutorService.executeReadQuery("select * from loan where \"bookISBN\" = " + bookISBN, new LoanEntityMapper());
        List<LoanEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof LoanEntity) {
                result.add((LoanEntity) object);
            } else {
                throw new RuntimeException("Expected LoanEntity instance");
            }
        }

        return result;
    }

    public static List<LoanEntity> findAllForReader(Integer readerId) {

        List<Object> objects = QueryExecutorService.executeReadQuery("select * from loan where \"readerId\" = " + readerId, new LoanEntityMapper());
        List<LoanEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof LoanEntity) {
                result.add((LoanEntity) object);
            } else {
                throw new RuntimeException("Expected LoanEntity instance");
            }
        }

        return result;
    }

    public static void addLoan(LoanEntity loanEntity) {
        Date loanDate = new Date(loanEntity.getLoanDate().getTime());
        Date returnDate = new Date(loanEntity.getReturnDate().getTime());

        QueryExecutorService.executeUpdateQuery("insert into loan values(TO_DATE('" + loanDate + "', 'YYYY-MM-DD HH:MI:SS'), TO_DATE('" + returnDate + "', 'YYYY-MM-DD HH:MI:SS'), " + loanEntity.getLoanedBook().getIsbn() + ", " + loanEntity.getLoaner().getId() + ")");
    }

    public static void deleteLoan(java.util.Date _loanDate, java.util.Date _returnDate, Integer readerId) {
        Date loanDate = new Date(_loanDate.getTime());
        Date returnDate = new Date(_returnDate.getTime());

        QueryExecutorService.executeUpdateQuery("delete from loan where \"loanDate\" = TO_DATE('" + loanDate + "', 'YYYY-MM-DD HH:MI:SS') and \"returnDate\" = TO_DATE('" + returnDate + "', 'YYYY-MM-DD HH:MI:SS') and \"readerId\" = " + readerId);
    }
}
