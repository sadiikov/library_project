package service;

import entity.Borrow;
import entity.History;
import entity.Role;
import entity.User;

import java.util.ArrayList;
import java.util.UUID;

import static db.DataBase.*;

public class AuthService {
    public static void service(){
        while (true){
            System.out.println("""
                    0 exit
                    1 sign in
                    2 sign up
                    """);
            switch (intscan.nextInt()){
                case 0 -> {return;}
                case 1 -> signIn();
                case 2 -> signUp();
                default -> System.out.println("No such action");
            }
        }
    }

    private static void signIn() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("  ============================  ");
        System.out.println(" |                             | ");
        System.out.println(" |  WELCOME TO THE SYSTEM      | ");
        System.out.println(" |   PLEASE SIGN IN BELOW      | ");
        System.out.println(" |=============================| ");
        System.out.println("\n  ================================");
        System.out.println("  |  ENTER YOUR EMAIL:            |");
        System.out.println("  ================================");
        String email = strscan.nextLine();
        System.out.println("  ================================");
        System.out.println("  |  ENTER YOUR PASSWORD:         |");
        System.out.println("  ================================");
        String password = strscan.nextLine();

        boolean signed = false;

        for (User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                setCurrentUser(user);
                signed = true;
            }
        }

        if(signed){
            System.out.println("\n  ================================");
            System.out.println("  |  SIGN-IN SUCCESSFUL!          |");
            System.out.println("  ================================");

            if(getCurrentUser().getRole() == Role.USER){
                System.out.println("  ================================");
                System.out.println("  |  YOU ARE LOGGED IN AS A USER. |");
                System.out.println("  ================================");
                new UserService().service();
            } else {
                System.out.println("  ================================");
                System.out.println("  |  YOU ARE LOGGED IN AS ADMIN.  |");
                System.out.println("  ================================");
                new AdminService().service();
            }
        } else {
            System.out.println("\n  ================================");
            System.out.println("  | ERROR: EMAIL OR PASSWORD IS   |");
            System.out.println("  | INCORRECT.                    |");
            System.out.println("  ================================");
        }
    }


    private static void signUp() {
        System.out.println("  ================================");
        System.out.println("  |  ENTER YOUR EMAIL:            |");
        System.out.println("  ================================");
        String email = strscan.nextLine();

        if(emailIsUnique(email)){
            User user = new User();

            System.out.println("  ================================");
            System.out.println("  |  ENTER YOUR PASSWORD:         |");
            System.out.println("  ================================");
            user.setPassword(strscan.nextLine());

            user.setId(UUID.randomUUID().toString());

            System.out.println("  ================================");
            System.out.println("  |  ENTER YOUR NAME:             |");
            System.out.println("  ================================");
            user.setName(strscan.nextLine());

            System.out.println("  ================================");
            System.out.println("  |  ENTER YOUR SURNAME:          |");
            System.out.println("  ================================");
            user.setSurname(strscan.nextLine());

            user.setEmail(email);
            user.setRole(Role.USER);

            user.setHistories(new ArrayList<History>());
            user.setBorrows(new ArrayList<Borrow>());
            user.setBalance(0.0);

            users.add(user);

            System.out.println("  ================================");
            System.out.println("  |  SIGN-UP SUCCESSFUL!          |");
            System.out.println("  ================================");
        }else{
            System.out.println("  ================================");
            System.out.println("  |  THIS EMAIL IS ALREADY        |");
            System.out.println("  |  SIGNED UP!                   |");
            System.out.println("  ================================");
        }
    }


    private static boolean emailIsUnique(String email) {
        for (User user : users) {
            if(user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
}
