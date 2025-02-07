import service.AuthService;

public class Main {
    public static void main(String[] args) {
        while (true){
            try{
                new AuthService().service();
            }catch (Exception e){
                System.out.println("An error occurred. Please try again.");
            }
        }
    }
}