package Library;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser (String name){
        super(name);
        this.operations=new IOOperation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBooks(),
                new Exit()
        };
    }
    public NormalUser(String name,String email,String phonenumber)
    {
        super(name,email,phonenumber);
        this.operations=new IOOperation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBooks(),
                new Exit()
        };
    }
    @Override
    public void menu(Database database,User user){
        System.out.println("1.View Books");
        System.out.println("2.Search");
        System.out.println("3.Place Order");
        System.out.println("4.Borrow Book");
        System.out.println("5.Calculate fine");
        System.out.println("6.Return Books");
        System.out.println("7.Exit");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        this.operations[n-1].oper(database,user);
        sc.close();

    }

    @Override
    public String toString() {
        return getName() + "<N/>" + getEmail() + "<N/>" + getPhoneNumber() + "<N/>" + "NormalUser";
    }

}
