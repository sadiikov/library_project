package service;

import static db.DataBase.*;

public class UserService {
    public void service(){
        System.out.println("""
                0 exit
                1 show sections
                2 show section
                3 borrow (up to 5)
                4 return book
                5 current borrowed books
                6 history
                """);
        switch (intscan.nextInt()){
            case 0 -> {return;}
//            case 1 -> showSections();
//            case 2 -> showSectionById();
//            case 3 -> borrow();
//            case 4 -> returnBook();
//            case 5 -> currentBorrowedBooks();
//            case 6 -> historyOfBorrowedBooks();
            default -> System.out.println("incorrect command");
        }
    }
}
