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
        System.out.println("Enter email: ");
        String email = strscan.nextLine();
        System.out.println("Enter password: ");
        String password = strscan.nextLine();
        boolean signed = false;
        for (User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                setCurrentUser(user);
                signed = true;
            }
        }

        if(signed){
            if(getCurrentUser().getRole() == Role.USER){
                new UserService().service();
            }else{
                new AdminService().service();
            }
        }else{
            System.out.println("email or password is incorrect");
        }
    }

    private static void signUp() {
        System.out.println("Enter email: ");
        String email = strscan.nextLine();

        if(emailIsUnique(email)){
            User user = new User();

            System.out.println("Enter your password: ");
            user.setPassword(strscan.nextLine());

            user.setId(UUID.randomUUID().toString());
            System.out.println("Enter name: ");
            user.setName(strscan.nextLine());
            System.out.println("Enter surname: ");
            user.setSurname(strscan.nextLine());
            user.setEmail(email);
            user.setRole(Role.USER);
            user.setHistories(new ArrayList<History>());
            user.setBorrows(new ArrayList<Borrow>());
            user.setBalance(0.0);

            users.add(user);
        }else{
            System.out.println("This email is already signed up!");
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
