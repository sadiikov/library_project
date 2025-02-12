package db;

import entity.*;

import java.util.*;

public class DataBase {

    public static Scanner intscan = new Scanner(System.in);
    public static Scanner strscan = new Scanner(System.in);

    private static User currentUser;
    public static User getCurrentUser(){return currentUser;}
    public static void setCurrentUser(User user){currentUser = user;}

    public static List<User> users = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<Section> sections = new ArrayList<>();

    static {
        users.add(new User(UUID.randomUUID().toString(), "admin", "admin", "admin", "admin", Role.ADMIN, new ArrayList<History>(), new ArrayList<Borrow>() , 0.0));
        users.add(new User(UUID.randomUUID().toString(), "a", "a", "a", "a", Role.USER, new ArrayList<History>(), new ArrayList<Borrow>() , 0.0));
        users.add(new User(UUID.randomUUID().toString(), "b", "b", "b", "b", Role.USER, new ArrayList<History>(), new ArrayList<Borrow>() , 0.0));

        books.add(new Book(UUID.randomUUID().toString(), "oppog'oy", "AkaUkaGreen", new Section(), 1, 1, BookState.AVAILABLE));

        sections.add(new Section(UUID.randomUUID().toString(), "love", new ArrayList<Book>(), SectionStatus.ENABLED));
    }
}
