package Library;

import java.util.Scanner;

public class AddBook implements IOOperation{
    @Override
    public void oper(Database database,User user) {
        Scanner sc=new Scanner(System.in);
        Book book=new Book();
        System.out.println("Enter book name:");
        String name=sc.next();
        if(database.getBook(name)>-1){
            System.out.println("There is a book with this name");
            user.menu(database,user);
            return;
        }else{
            book.setName(name);
            System.out.println("Enter book Author:");
            book.setAuthor(sc.next());
            System.out.println("Enter book publisher:");
            book.setPublisher(sc.next());
            System.out.println("Enter book Collection address:");
            book.setAddress(sc.next());
            System.out.println("Enter book Qty:");
            book.setQty(sc.nextInt());
            System.out.println("Enter book price:");
            book.setPrice(sc.nextDouble());
            System.out.println("Enter borrowing copies:");
            book.setBrwcopies(sc.nextInt());

            database.AddBook(book);
            System.out.println("Book added Successfully\n");
            user.menu(database,user);

        }

    }
}
