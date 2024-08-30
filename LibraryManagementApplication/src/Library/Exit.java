package Library;

import java.util.Scanner;

import static Library.Main.database;
import static Library.Main.sc;

public class Exit implements IOOperation {
    Scanner sc=new Scanner(System.in);
    Database database;
    User user;

    @Override
    public void oper(Database database, User user) {
        this.database = database;
        this.user = user;
        System.out.println("\nAre you sure that you want to quit\n"
                + "1.Yes\n2.Main Menu");

        int i = sc.nextInt();
        if (i == 1) {
            System.out.println("0.Exit\n1.Login\n2.New User");
            sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    login();
                    break;

                case 2:
                    newuser();
                    break;
                default:
                    System.out.println("Error");
            }
        } else {
            user.menu(database, user);
        }
    }


    private void login() {
        System.out.println("Enter a PhoneNuber:");
        String phonenumber = sc.next(); // trim to remove any extra spaces
        System.out.println("Enter a email:");
        String email = sc.next(); // trim to remove any extra spaces
        int n = database.login(phonenumber, email);
        if (n != -1) {
            User user = database.getUser(n);
            user.menu(database, user);
        } else {
            System.out.println(n);
        }
    }

    private void newuser() {
        System.out.println("Enter a Name:");
        String name = sc.next();
        System.out.println("Enter a PhoneNuber:");
        String phonenumber = sc.next();
        System.out.println("Enter a email:");
        String email = sc.next();
        System.out.println("1.Admin\n2.Normal User");
        int n2 = sc.nextInt();
        User user;
        if (n2 == 1) {
            user = new Admin(name, email, phonenumber);

        } else {
            user = new NormalUser(name, email, phonenumber);
        }
        database.AddUser(user);
        user.menu(database, user);
    }
}
