package Library;

import javax.xml.crypto.Data;
import java.util.*;
public class Main {
    static Scanner sc;
    static Database database;

    public static void main(String[] args) {

        database=new Database();
        System.out.println("Welcome to Library Management System!");
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
            }
    }

        private static void login() {
        System.out.println("Enter a PhoneNuber:");
        String phonenumber = sc.next(); // trim to remove any extra spaces
        System.out.println("Enter a email:");
        String email = sc.next(); // trim to remove any extra spaces
        int n = database.login(phonenumber, email);
        if (n != -1) {
            User user = database.getUser(n);
            user.menu(database,user);
        } else {
            System.out.println(n);
        }
    }
    private static void newuser() {
        System.out.println("Enter a Name:");
        String name = sc.next();
        if(database.userExists(name)){
            System.out.println("User exists!");
            newuser();
        }
        System.out.println("Enter a PhoneNuber:");
        String phonenumber = sc.next();
        System.out.println("Enter a email:");
        String email = sc.next();
        System.out.println("1.Admin\n2.Normal User");
        int n2 = sc.nextInt();
        User user;
        if (n2 == 1) {
            user = new Admin(name, email,phonenumber);

        } else {
            user = new NormalUser(name, email, phonenumber);
        }
        database.AddUser(user);
        user.menu(database,user);
        }


    }