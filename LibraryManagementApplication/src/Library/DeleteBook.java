package Library;

import java.util.Scanner;

public class DeleteBook implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter book name");
        String bookname=sc.next();
        int i=database.getBook(bookname);
        if(i>-1){
            database.deleteBook(i);
            System.out.println("Book deleted Successfully");

        }else{
            System.out.println("Book doesn't exist");
        }
        user.menu(database,user);
    }
}
