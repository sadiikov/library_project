package service;

import entity.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.UUID;

import static db.DataBase.*;

public class UserService {
    public void service(){
        while(true) {
            System.out.println("""
                    0 exit
                    1 show sections
                    2 show section
                    3 borrow (up to 5)
                    4 return book
                    5 current borrowed books
                    6 history
                    """);
            switch (intscan.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> showSections();
                case 2 -> showSectionById();
                case 3 -> borrow();
                case 4 -> returnBook();
                case 5 -> currentBorrowedBooks();
                case 6 -> historyOfBorrowedBooks();
                default -> System.out.println("incorrect command");
            }
        }
    }

    private void historyOfBorrowedBooks() {
        User user = getCurrentUser();

        for (History history : user.getHistories()) {
            System.out.println("- " + history.getBook().getTitle() + " borrowed date time - " + history.getBorrowDateTime() + " returned date time - " + history.getReturnDateTime());
        }
    }

    private void currentBorrowedBooks() {
        User user = getCurrentUser();

        for (Borrow borrow : user.getBorrows()) {
            System.out.println(" - book title - " + borrow.getBook().getTitle() + " borrowed date time - " + borrow.getBorrowedDateTime());
        }
    }

    private void returnBook() {
        System.out.println("Enter title of the book: ");
        String title = strscan.nextLine();

        User user = getCurrentUser();
        boolean found = false;

        for (Iterator<Borrow> iterator = user.getBorrows().iterator(); iterator.hasNext();) {
            Borrow borrow = iterator.next();

            if(borrow.getBook().getTitle().equalsIgnoreCase(title) && borrow.getBorrowState() == BorrowState.BORROWED){
                found = true;

                LocalDateTime returnDateTime = LocalDateTime.now();
                borrow.setReturnDateTime(returnDateTime);
                borrow.setBorrowState(BorrowState.RETURNED);

                long borrowedTime = Duration.between(borrow.getBorrowedDateTime(), returnDateTime).toMinutes();
                long fee = borrowedTime * 500;
                user.setBalance(user.getBalance() - fee);

                borrow.getBook().setAvailableBooks(borrow.getBook().getAvailableBooks() + 1);

                iterator.remove();
                user.getHistories().add(new History(user, borrow.getBook(), borrow.getBorrowedDateTime(), returnDateTime));

                System.out.println("Book returned successfully. Fee: " + fee + " UZS");
                break;
            }
        }

        if(!found) System.out.println("Book not found");
    }

    private void borrow() {
        System.out.println("Enter book title: ");
        String title = strscan.nextLine();
        boolean found = false;
        User user = getCurrentUser();

        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title) && book.getAvailableBooks() > 0 && user.getBorrows().size() < 5){
                found = true;
                Borrow borrow = new Borrow(UUID.randomUUID().toString(), user, book, BorrowState.BORROWED, LocalDateTime.now(), null);
                user.getBorrows().add(borrow);
                History history = new History(user, book, LocalDateTime.now(), null);
                user.getHistories().add(history);
                book.setAvailableBooks(book.getAvailableBooks() - 1);
                System.out.println("Book borrowed " + book.getTitle());
                break;
            }
        }
        if(!found) System.out.println("Book not found or unavailable");
    }


    private void showSectionById() {
        System.out.println("Enter section id: ");
        String id = strscan.nextLine();
        boolean found = false;

        for (Section section : sections) {
            if(section.getId().equalsIgnoreCase(id)){
                found = true;

                System.out.println(section);
            }
        }
        if(!found) System.out.println("Section not found");
    }

    private void showSections() {
        if (sections.isEmpty()) {
            System.out.println("No sections available.");
        }else {
            System.out.println("Available sections:");
            for (Section section : sections) {
                System.out.println("- " + section.getName() + " section id - " + section.getId() + " (Status: " + section.getSectionStatus() + ")");
            }
        }
    }
}
