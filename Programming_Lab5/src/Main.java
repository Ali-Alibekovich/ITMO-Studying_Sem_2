import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Users> users = new HashSet<>();
        users.add(new Users(2,"Ali"));
        users.add(new Users(2,"Ali"));
        users.add(new Users(1,"Hussein"));
        for (Users user:users){
            System.out.println(user);
        }

    }
}
