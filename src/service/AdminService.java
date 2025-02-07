package service;

import static db.DataBase.*;
import entity.Section;
import entity.SectionStatus;

import java.util.ArrayList;
import java.util.UUID;
public class AdminService {
    public void service(){
        while (true){
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
            switch (intscan.nextInt()){
                case 0 -> {return;}
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

    private void addSection() {
        System.out.println("Enter section name:");
        String sectionName = scanner.nextLine();

        Section newSection = new Section(UUID.randomUUID().toString(), sectionName, new ArrayList<>(), SectionStatus.ENABLED);
        sections.add(newSection);

        System.out.println("Section added successfully: " + sectionName);
    }
}

