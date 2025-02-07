package entity;

import java.time.LocalDateTime;

public class Borrow {
    private String id;
    private User user;
    private Book book;
    private BorrowState borrowState;
    private LocalDateTime borrowedDateTime;
    private LocalDateTime returnDateTime;

    public Borrow() {
    }

    public Borrow(String id, User user, Book book, BorrowState borrowState, LocalDateTime borrowedDateTime, LocalDateTime returnDateTime) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowState = borrowState;
        this.borrowedDateTime = borrowedDateTime;
        this.returnDateTime = returnDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowState getBorrowState() {
        return borrowState;
    }

    public void setBorrowState(BorrowState borrowState) {
        this.borrowState = borrowState;
    }

    public LocalDateTime getBorrowedDateTime() {
        return borrowedDateTime;
    }

    public void setBorrowedDateTime(LocalDateTime borrowedDateTime) {
        this.borrowedDateTime = borrowedDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", book=" + book +
                ", borrowState=" + borrowState +
                ", borrowedDateTime=" + borrowedDateTime +
                ", returnDateTime=" + returnDateTime +
                '}';
    }
}
