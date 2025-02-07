package service;

import static db.DataBase.*;

import entity.Book;
import entity.Section;
import entity.SectionStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
public class AdminService {
    public void service() {
        while (true) {
            System.out.println("""
                    0 exit
                    1 add section
                    2 show sections
                    3 show section (with books)
                    4 section state
                    5 add book
                    6 remove book
                    7 book state
                    8 show users
                    9 show user (books borrowed)
                    """);
            switch (intscan.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> addSection();
                case 2 -> showSections();
                case 3 -> showSectionWithBooks();
                case 4 -> setSectionState();
                case 5 -> addBook();
                case 6 -> removeBook();
                case 7 -> setBookState();
                case 8 -> showUsers();
                case 9 -> showBorrowedBooksUserById();
                default -> System.out.println("incorrect command");
            }
        }
    }

    private static void addSection() {
        System.out.println("Enter section name:");
        String sectionName = strscan.nextLine();

        Section newSection = new Section(UUID.randomUUID().toString(), sectionName, new ArrayList<>(), SectionStatus.ENABLED);
        sections.add(newSection);

        System.out.println("Section added successfully: " + sectionName);
    }

    private static void showSections() {
        if (sections.isEmpty()) {
            System.out.println("No sections available.");
            return;
        }
        System.out.println("Available sections:");
        for (Section section : sections) {
            System.out.println("- " + section.getName() + " (Status: " + section.getSectionStatus() + ")");
        }
    }

    private static void showSectionWithBooks() {
        System.out.println("Enter section name:");
        String sectionName = strscan.nextLine();

        for (Section section : sections) {
            if (section.getName().equalsIgnoreCase(sectionName)) {
                System.out.println("Books in section " + sectionName + ":");
                if (section.getBooks().isEmpty()) {
                    System.out.println("No books available in this section.");
                } else {
                    for (Book book : section.getBooks()) {
                        System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
                    }
                }
                return;
            }
        }
        System.out.println("Section not found.");

    }

    private static void setSectionState() {
        System.out.println("Enter section name:");
        String sectionName = strscan.nextLine();

        for (Section section : sections) {
            if (section.getName().equalsIgnoreCase(sectionName)) {
                System.out.println("Current status: " + section.getSectionStatus());
                System.out.println("Enter new status (ENABLED/DISABLED):");
                String newStatus = strscan.nextLine().toUpperCase();

                try {
                    section.setSectionStatus(SectionStatus.valueOf(newStatus));
                    System.out.println("Section status updated successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid status. Please enter ENABLED or DISABLED.");
                }
                return;
            }
        }
        System.out.println("Section not found.");
    }

    private static void addBook() {
        System.out.println("Enter section name to add book:");
        String sectionName = strscan.nextLine();

        for (Section section : sections) {
            if (section.getName().equalsIgnoreCase(sectionName)) {
                System.out.println("Enter book title:");
                String title = strscan.nextLine();
                System.out.println("Enter book author:");
                String author = strscan.nextLine();
                System.out.println("Enter total copies:");
                int totalBooks = strscan.nextInt();
                strscan.nextLine();

                Book newBook = new Book(UUID.randomUUID().toString(), title, author, section, totalBooks, totalBooks);
                books.add(newBook);
                section.getBooks().add(newBook);

                System.out.println("Book added successfully: " + title);
                return;
            }
        }
        System.out.println("Section not found.");
    }


    private static void removeBook() {
        System.out.println("Enter book title to remove:");
        String bookTitle = strscan.nextLine();

        for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                iterator.remove();
                book.getSection().getBooks().remove(book);
                System.out.println("Book removed successfully: " + bookTitle);
                return;
            }
        }
        System.out.println("Book not found.");
    }



}

