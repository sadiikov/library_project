package entity;

public class Book {
    private String id;
    private String title;
    private String author;
    private Section section;
    private Integer totalBooks;
    private Integer availableBooks;
    private BookState bookState;

    public Book() {
    }

    public Book(String id, String title, String author, Section section, Integer totalBooks, Integer availableBooks, BookState bookState) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.section = section;
        this.totalBooks = totalBooks;
        this.availableBooks = availableBooks;
        this.bookState = bookState;
    }

    public BookState getBookState() {
        return bookState;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(Integer totalBooks) {
        this.totalBooks = totalBooks;
    }

    public Integer getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(Integer availableBooks) {
        this.availableBooks = availableBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", section=" + section +
                ", totalBooks=" + totalBooks +
                ", availableBooks=" + availableBooks +
                ", bookState=" + bookState +
                '}';
    }
}
