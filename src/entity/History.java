package entity;

import java.time.LocalDateTime;

public class History {
    private User user;
    private Book book;
    private LocalDateTime borrowDateTime;
    private LocalDateTime returnDateTime;

    public History() {
    }

    public History(User user, Book book, LocalDateTime borrowDateTime, LocalDateTime returnDateTime) {
        this.user = user;
        this.book = book;
        this.borrowDateTime = borrowDateTime;
        this.returnDateTime = returnDateTime;
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

    public LocalDateTime getBorrowDateTime() {
        return borrowDateTime;
    }

    public void setBorrowDateTime(LocalDateTime borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    @Override
    public String toString() {
        return "History{" +
                "user=" + user +
                ", book=" + book +
                ", borrowDateTime=" + borrowDateTime +
                ", returnDateTime=" + returnDateTime +
                '}';
    }
}
