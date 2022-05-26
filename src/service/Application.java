package service;

import model.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        while (true) {
            System.out.println("Please choose a number:");

            System.out.println();

            System.out.println("--> 0. EXIT.");

            System.out.println();

            System.out.println("-------------------- AUTHOR --------------------");
            System.out.println("--> 1. Show all authors.");
            System.out.println("--> 2. Show a specific author (by ID).");
            System.out.println("--> 3. Add a new author.");
            System.out.println("--> 4. Delete an author.");
            System.out.println("--> 5. Update the name of a specific author.");
            System.out.println("--> 6. Update the age of a specific author.");

            System.out.println();

            System.out.println("--------------------- BOOK ---------------------");
            System.out.println("--> 7. Show all books.");
            System.out.println("--> 8. Show a specific book (by ISBN).");
            System.out.println("--> 9. Show all books for a specific author (by author ID).");
            System.out.println("--> 10. Show all books for a specific section (by section ID).");
            System.out.println("--> 11. Add a new book.");
            System.out.println("--> 12. Delete a book.");
            System.out.println("--> 13. Update the title of a specific book.");
            System.out.println("--> 14. Update the price of a specific book.");
            System.out.println("--> 15. Update the number of pages of a specific book.");

            System.out.println();

            System.out.println("------------------- TEXTBOOK -------------------");
            System.out.println("--> 16. Show all textbooks.");
            System.out.println("--> 17. Show all textbooks for a specific author (by author ID).");
            System.out.println("--> 18. Show all textbooks for a specific section (by section ID).");
            System.out.println("--> 19. Add a new textbook.");
            System.out.println("--> 20. Delete a textbook.");
            System.out.println("--> 21. Update the title of a specific textbook.");
            System.out.println("--> 22. Update the price of a specific textbook.");
            System.out.println("--> 23. Update the number of pages of a specific textbook.");
            System.out.println("--> 24. Update the subject of a specific textbook.");

            System.out.println();

            System.out.println("--------------------- LOAN ---------------------");
            System.out.println("--> 25. Show all loans.");
            System.out.println("--> 26. Show all loans for a specific book (by book ISBN).");
            System.out.println("--> 27. Show all loans for a specific reader (by reader ID).");
            System.out.println("--> 28. Add a new loan.");
            System.out.println("--> 29. Delete a loan.");

            System.out.println();

            System.out.println("-------------------- READER --------------------");
            System.out.println("--> 30. Show all readers.");
            System.out.println("--> 31. Show a specific reader (by ID).");
            System.out.println("--> 32. Add a new reader.");
            System.out.println("--> 33. Delete a reader.");
            System.out.println("--> 34. Update the name of a specific reader.");
            System.out.println("--> 35. Update the age of a specific reader.");


            System.out.println();

            System.out.println("------------------- STUDENT --------------------");
            System.out.println("--> 36. Show all students.");
            System.out.println("--> 37. Add a new student.");
            System.out.println("--> 38. Delete a student.");
            System.out.println("--> 39. Update the name of a specific student.");
            System.out.println("--> 40. Update the age of a specific student.");
            System.out.println("--> 41. Update the university of a specific student.");
            System.out.println("--> 42. Update the year of university of a specific student.");

            System.out.println();

            System.out.println("------------------- SECTION --------------------");
            System.out.println("--> 43. Show all sections.");
            System.out.println("--> 44. Show a specific section (by ID).");
            System.out.println("--> 45. Add a new section");
            System.out.println("--> 46. Delete a section");

            System.out.println();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.print("YOUR OPTION IS: ");
            try {
                int option = scanner.nextInt();

                System.out.println();

                if (option == 0) {
                    System.out.println("Goodbye!");
                    break;
                } else if (option == 1) {
                    Audit.logAction("SHOW", "AUTHOR");
                    System.out.println(AuthorService.getAllAuthors());
                } else if (option == 2) {
                    Audit.logAction("SHOW", "AUTHOR");
                    scanner = new Scanner(System.in);
                    System.out.print("Author ID: ");
                    int authorId = scanner.nextInt();

                    System.out.println(AuthorService.getAuthor(authorId));
                } else if (option == 3) {
                    Audit.logAction("INSERT", "AUTHOR");
                    scanner = new Scanner(System.in);
                    System.out.print("Author ID: ");
                    int authorId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Author name: ");
                    String authorName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Author age (0 if unknown/dead): ");
                    int authorAge = scanner.nextInt();

                    try {
                        AuthorService.addAuthor(new Author(authorId, authorName, authorAge));
                    } catch (Exception e) {
                        System.out.println("Author couldn't be added due to " + e);
                    }
                } else if (option == 4) {
                    Audit.logAction("DELETE", "AUTHOR");
                    scanner = new Scanner(System.in);
                    System.out.print("Insert author name that will be deleted: ");
                    String authorName = scanner.nextLine();

                    try {
                        AuthorService.deleteAuthor(authorName);
                    } catch (Exception e) {
                        System.out.println("Author couldn't be deleted due to " + e);
                    }
                } else if (option == 5) {
                    Audit.logAction("UPDATE", "AUTHOR");
                    scanner = new Scanner(System.in);
                    System.out.print("Author name (actual name): ");
                    String authorName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Author new name: ");
                    String authorNewName = scanner.nextLine();

                    AuthorService.updateAuthorsName(authorName, authorNewName);
                } else if (option == 6) {
                    Audit.logAction("UPDATE", "AUTHOR");
                    scanner = new Scanner(System.in);
                    System.out.print("Author name: ");
                    String authorName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Author new age: ");
                    int authorNewAge = scanner.nextInt();

                    AuthorService.updateAuthorsAge(authorName, authorNewAge);
                } else if (option == 7) {
                    Audit.logAction("SHOW", "BOOK");
                    System.out.println(BookService.getAllBooks());
                } else if (option == 8) {
                    Audit.logAction("SHOW", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Book ISBN: ");
                    long bookISBN = scanner.nextLong();

                    System.out.println(BookService.getBook(bookISBN));
                } else if (option == 9) {
                    Audit.logAction("SHOW", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Author ID: ");
                    int authorId = scanner.nextInt();

                    System.out.println(BookService.getAllBooksForAuthor(authorId));
                } else if (option == 10) {
                    Audit.logAction("SHOW", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Section ID: ");
                    int sectionId = scanner.nextInt();

                    System.out.println(BookService.getAllBooksForSection(sectionId));
                } else if (option == 11) {
                    Audit.logAction("INSERT", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Book ISBN: ");
                    Long bookISBN = scanner.nextLong();

                    scanner = new Scanner(System.in);
                    System.out.print("Book title: ");
                    String bookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Book number of pages:  ");
                    int bookNumberOfPages = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Book price:  ");
                    float bookPrice = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Author ID:  ");
                    int authorId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Section ID:  ");
                    int sectionId = scanner.nextInt();

                    try {
                        BookService.addBook(new Book(bookISBN, bookTitle, bookNumberOfPages, bookPrice), authorId, sectionId);
                    } catch (Exception e) {
                        System.out.println("Book couldn't be added due to " + e);
                    }
                } else if (option == 12) {
                    Audit.logAction("DELETE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Insert book title that will be deleted: ");
                    String bookTitle = scanner.nextLine();

                    try {
                        BookService.deleteBook(bookTitle);
                    } catch (Exception e) {
                        System.out.println("Book couldn't be deleted due to " + e);
                    }
                } else if (option == 13) {
                    Audit.logAction("UPDATE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Book title (actual title): ");
                    String bookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Book new title: ");
                    String bookNewTitle = scanner.nextLine();

                    BookService.updateBooksTitle(bookTitle, bookNewTitle);
                } else if (option == 14) {
                    Audit.logAction("UPDATE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Book title: ");
                    String bookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Book new price: ");
                    float bookNewPrice = scanner.nextFloat();

                    BookService.updateBooksPrice(bookTitle, bookNewPrice);
                } else if (option == 15) {
                    Audit.logAction("UPDATE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Book title: ");
                    String bookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Book new number of pages: ");
                    int bookNewNumberOfPages = scanner.nextInt();

                    BookService.updateBooksNumberOfPages(bookTitle, bookNewNumberOfPages);
                } else if (option == 16) {
                    Audit.logAction("SHOW", "BOOK");
                    System.out.println(TextBookService.getAllTextBooks());
                } else if (option == 17) {
                    Audit.logAction("SHOW", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Author ID: ");
                    int authorId = scanner.nextInt();

                    System.out.println(TextBookService.getAllTextBooksForAuthor(authorId));
                } else if (option == 18) {
                    Audit.logAction("SHOW", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Section ID: ");
                    int sectionId = scanner.nextInt();

                    System.out.println(TextBookService.getAllTextBooksForSection(sectionId));
                } else if (option == 19) {
                    Audit.logAction("INSERT", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("TextBook ISBN: ");
                    Long textBookISBN = scanner.nextLong();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook title: ");
                    String textBookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook number of pages:  ");
                    int textBookNumberOfPages = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook price:  ");
                    float textBookPrice = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Author ID:  ");
                    int authorId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Section ID:  ");
                    int sectionId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook Subject:  ");
                    String textBookSubject = scanner.nextLine();

                    try {
                        TextBookService.addTextBook(new TextBook(textBookISBN, textBookTitle, textBookNumberOfPages, textBookPrice, textBookSubject), authorId, sectionId);
                    } catch (Exception e) {
                        System.out.println("TextBook couldn't be added due to " + e);
                    }
                } else if (option == 20) {
                    Audit.logAction("DELETE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("Insert textbook title that will be deleted: ");
                    String textBookTitle = scanner.nextLine();

                    try {
                        TextBookService.deleteTextBook(textBookTitle);
                    } catch (Exception e) {
                        System.out.println("TextBook couldn't be deleted due to " + e);
                    }
                } else if (option == 21) {
                    Audit.logAction("UPDATE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("TextBook title (actual title): ");
                    String textBookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook new title: ");
                    String textBookNewTitle = scanner.nextLine();

                    TextBookService.updateTextBooksTitle(textBookTitle, textBookNewTitle);
                } else if (option == 22) {
                    Audit.logAction("UPDATE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("TextBook title: ");
                    String textBookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook new price: ");
                    float textBookNewPrice = scanner.nextFloat();

                    TextBookService.updateTextBooksPrice(textBookTitle, textBookNewPrice);
                } else if (option == 23) {
                    Audit.logAction("UPDATE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("TextBook title: ");
                    String textBookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook new number of pages: ");
                    int textBookNewNumberOfPages = scanner.nextInt();

                    TextBookService.updateTextBooksNumberOfPages(textBookTitle, textBookNewNumberOfPages);
                } else if (option == 24) {
                    Audit.logAction("UPDATE", "BOOK");
                    scanner = new Scanner(System.in);
                    System.out.print("TextBook title: ");
                    String textBookTitle = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("TextBook new subject: ");
                    String textBookNewSubject = scanner.nextLine();

                    TextBookService.updateTextBooksSubject(textBookTitle, textBookNewSubject);
                } else if (option == 25) {
                    Audit.logAction("SHOW", "LOAN");
                    System.out.println(LoanService.getAllLoans());
                } else if (option == 26) {
                    Audit.logAction("SHOW", "LOAN");
                    scanner = new Scanner(System.in);
                    System.out.print("Book ISBN: ");
                    long bookISBN = scanner.nextLong();

                    System.out.println(LoanService.getAllLoansForBook(bookISBN));
                } else if (option == 27) {
                    Audit.logAction("SHOW", "LOAN");
                    scanner = new Scanner(System.in);
                    System.out.print("Reader ID: ");
                    int readerId = scanner.nextInt();

                    System.out.println(LoanService.getAllLoansForReader(readerId));
                } else if (option == 28) {
                    Audit.logAction("INSERT", "LOAN");
                    scanner = new Scanner(System.in);
                    System.out.print("Loan Date (NOW or FORMAT: yyyy-MM-dd HH:mm:ss): ");
                    String loanDateString = scanner.nextLine();
                    Date loanDate;

                    if (loanDateString.equals("NOW")) {
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        loanDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeFormatter.format(now));
                    } else {
                        loanDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(loanDateString);
                    }

                    scanner = new Scanner(System.in);
                    System.out.print("Return Date (FORMAT: yyyy-MM-dd HH:mm:ss): ");
                    String returnDateString = scanner.nextLine();

                    Date returnDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(returnDateString);

                    scanner = new Scanner(System.in);
                    System.out.print("Reader ID:  ");
                    int readerId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Book ISBN:  ");
                    long bookISBN = scanner.nextLong();

                    System.out.println(loanDate);
                    System.out.println(returnDate);

                    try {
                        LoanService.addLoan(new Loan(loanDate, returnDate), readerId, bookISBN);
                    } catch (Exception e) {
                        System.out.println("Loan couldn't be added due to " + e);
                        e.printStackTrace();
                    }
                } else if (option == 29) {
                    Audit.logAction("DELETE", "LOAN");
                    scanner = new Scanner(System.in);
                    System.out.print("Insert loan date that will be deleted (NOW or FORMAT: yyyy-MM-dd HH:mm:ss): ");
                    String loanDateString = scanner.nextLine();
                    Date loanDate;

                    if (loanDateString.equals("NOW")) {
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        loanDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeFormatter.format(now));
                    } else {
                        loanDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(loanDateString);
                    }

                    scanner = new Scanner(System.in);
                    System.out.print("Insert return date that will be deleted (FORMAT: yyyy-MM-dd HH:mm:ss): ");
                    String returnDateString = scanner.nextLine();

                    Date returnDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(returnDateString);

                    scanner = new Scanner(System.in);
                    System.out.print("Insert loan reader ID that will be deleted: ");
                    int loanReaderID = scanner.nextInt();

                    try {
                        LoanService.deleteLoan(loanDate, returnDate, loanReaderID);
                    } catch (Exception e) {
                        System.out.println("Loan couldn't be deleted due to " + e);
                    }
                } else if (option == 30) {
                    Audit.logAction("SHOW", "READER");
                    System.out.println(ReaderService.getAllReaders());
                } else if (option == 31) {
                    Audit.logAction("SHOW", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Reader ID: ");
                    int readerId = scanner.nextInt();

                    System.out.println(ReaderService.getReader(readerId));
                } else if (option == 32) {
                    Audit.logAction("INSERT", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Reader ID: ");
                    int readerId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Reader name: ");
                    String readerName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Reader age: ");
                    int readerAge = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Reader register date (NOW or FORMAT: yyyy-MM-dd HH:mm:ss): ");
                    String readerRegisterDateString = scanner.nextLine();
                    Date readerRegisterDate;

                    if (readerRegisterDateString.equals("NOW")) {
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        readerRegisterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeFormatter.format(now));
                    } else {
                        readerRegisterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(readerRegisterDateString);
                    }

                    try {
                        ReaderService.addReader(new Reader(readerId, readerName, readerAge, readerRegisterDate));
                    } catch (Exception e) {
                        System.out.println("Reader couldn't be added due to " + e);
                    }
                } else if (option == 33) {
                    Audit.logAction("DELETE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Insert reader name that will be deleted: ");
                    String readerName = scanner.nextLine();

                    try {
                        ReaderService.deleteReader(readerName);
                    } catch (Exception e) {
                        System.out.println("Reader couldn't be deleted due to " + e);
                    }
                } else if (option == 34) {
                    Audit.logAction("UPDATE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Reader name (actual name): ");
                    String readerName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Reader new name: ");
                    String readerNewName = scanner.nextLine();

                    ReaderService.updateReadersName(readerName, readerNewName);
                } else if (option == 35) {
                    Audit.logAction("UPDATE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Reader name: ");
                    String readerName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Reader new age: ");
                    int readerNewAge = scanner.nextInt();

                    ReaderService.updateReadersAge(readerName, readerNewAge);
                } else if (option == 36) {
                    Audit.logAction("SHOW", "READER");
                    System.out.println(StudentService.getAllStudents());
                } else if (option == 37) {
                    Audit.logAction("INSERT", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Student ID: ");
                    int studentId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Student name: ");
                    String studentName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Student age: ");
                    int studentAge = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Student register date (NOW or FORMAT: yyyy-MM-dd HH:mm:ss): ");
                    String studentRegisterDateString = scanner.nextLine();
                    Date studentRegisterDate;
                    if (studentRegisterDateString.equals("NOW")) {
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        studentRegisterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeFormatter.format(now));
                    } else {
                        studentRegisterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(studentRegisterDateString);
                    }

                    scanner = new Scanner(System.in);
                    System.out.print("Student university: ");
                    String studentUniversity = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Student year: ");
                    int studentYear = scanner.nextInt();

                    try {
                        StudentService.addStudent(new Student(studentId, studentName, studentAge, studentRegisterDate, studentUniversity, studentYear));
                    } catch (Exception e) {
                        System.out.println("Student couldn't be added due to " + e);
                    }
                } else if (option == 38) {
                    Audit.logAction("DELETE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Insert student name that will be deleted: ");
                    String studentName = scanner.nextLine();

                    try {
                        StudentService.deleteStudent(studentName);
                    } catch (Exception e) {
                        System.out.println("Student couldn't be deleted due to " + e);
                    }
                } else if (option == 39) {
                    Audit.logAction("UPDATE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Student name (actual name): ");
                    String studentName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Student new name: ");
                    String studentNewName = scanner.nextLine();

                    StudentService.updateStudentsName(studentName, studentNewName);
                } else if (option == 40) {
                    Audit.logAction("UPDATE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Student name: ");
                    String studentName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Student new age: ");
                    int studentNewAge = scanner.nextInt();

                    StudentService.updateStudentsAge(studentName, studentNewAge);
                } else if (option == 41) {
                    Audit.logAction("UPDATE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Student name: ");
                    String studentName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Student new university: ");
                    String studentNewUniversity = scanner.nextLine();

                    StudentService.updateStudentsUniversity(studentName, studentNewUniversity);
                } else if (option == 42) {
                    Audit.logAction("UPDATE", "READER");
                    scanner = new Scanner(System.in);
                    System.out.print("Student name: ");
                    String studentName = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Student new year of university: ");
                    int studentNewYear = scanner.nextInt();

                    StudentService.updateStudentsYear(studentName, studentNewYear);
                } else if (option == 43) {
                    Audit.logAction("SHOW", "SECTION");
                    System.out.println(SectionService.getAllSections());
                } else if (option == 44) {
                    Audit.logAction("SHOW", "SECTION");
                    scanner = new Scanner(System.in);
                    System.out.print("Section ID: ");
                    int sectionId = scanner.nextInt();

                    System.out.println(SectionService.getSection(sectionId));
                } else if (option == 45) {
                    Audit.logAction("INSERT", "SECTION");
                    scanner = new Scanner(System.in);
                    System.out.print("Section ID: ");
                    int sectionId = scanner.nextInt();

                    scanner = new Scanner(System.in);
                    System.out.print("Section name: ");
                    String sectionName = scanner.nextLine();

                    try {
                        SectionService.addSection(new Section(sectionId, sectionName));
                    } catch (Exception e) {
                        System.out.println("Section couldn't be added due to " + e);
                    }
                } else if (option == 46) {
                    Audit.logAction("DELETE", "SECTION");
                    scanner = new Scanner(System.in);
                    System.out.print("Insert section name that will be deleted: ");
                    String sectionName = scanner.nextLine();

                    try {
                        SectionService.deleteSection(sectionName);
                    } catch (Exception e) {
                        System.out.println("Section couldn't be deleted due to " + e);
                    }
                } else {
                    System.out.println("Option is not correct. Please try again.");
                    break;
                }

                System.out.println();
                System.out.println();

                scanner = new Scanner(System.in);
                System.out.print("Do you want to choose another option? [y/n] --> ");
                String anotherOption = scanner.nextLine();

                if (anotherOption.equalsIgnoreCase("n") || anotherOption.equalsIgnoreCase("no")) {
                    System.out.println();
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong. Please try again.");
                e.printStackTrace();
            }

            scanner.close();
        }
    }
}