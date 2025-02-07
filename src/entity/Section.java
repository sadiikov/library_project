package entity;

import java.util.List;

public class Section {
    private String id;
    private String name;
    private List<Book> books;
    private SectionStatus sectionStatus;

    public Section() {
    }

    public Section(String id, String name, List<Book> books, SectionStatus sectionStatus) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.sectionStatus = sectionStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public SectionStatus getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(SectionStatus sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", sectionStatus=" + sectionStatus +
                '}';
    }
}
