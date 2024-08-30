package Library;

import java.util.Scanner;

public class Search implements IOOperation{
    @Override
    public void oper(Database database,User user) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter book name");
        String name=sc.next();
        int i=database.getBook(name);
        if(i>-1){
            System.out.println(database.getBook(i).toString());
            System.out.println("Book deleted Successfully");

        }else{
            System.out.println("Book doesn't exist");
        }
        user.menu(database,user);
    }
}
