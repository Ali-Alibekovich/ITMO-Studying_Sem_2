import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Users> users = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        int n=0;
        while (n!=3) {
            System.out.println("1.Добавть пользователя");
            System.out.println("2.Посмотреть список пользователей");
            System.out.println("3.Выход");
            n = scan.nextInt();
            if (n == 1) {
                int id;
                String name;
                System.out.println("Введите id и name (через пароль)");
                id = scan.nextInt();
                name = scan.next();
                users.add(new Users(id, name));
            }
            if (n == 2) {
                for (Users user : users) {
                    System.out.println(user);
                }
            }
        }
    }
}
