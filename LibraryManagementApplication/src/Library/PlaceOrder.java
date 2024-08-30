package Library;

import java.util.Scanner;

public class PlaceOrder implements IOOperation{
    @Override
    public void oper(Database database,User user) {
        Order order =new Order();
        System.out.println("\nEnter book nmae:");
        Scanner sc=new Scanner(System.in);
        String bookname=sc.next();
        int i=database.getBook(bookname);
        if(i<=-1){
            System.out.println("Book doesn't exist");

        }else {
            Book book=database.getBook(i);
            order.setBook(book);
            order.setUser(user);
            System.out.println("Enter qty:");
            int qty=sc.nextInt();
            order.setQty(qty);
            order.setPrice(book.getPrice()*qty);
            int bookindex=database.getBook(book.getName());
            book.setQty(book.getQty()-qty);
            database.addOrder(order,book,bookindex);
            System.out.println("Order placed Successful\n");

        }
        user.menu(database,user);
    }
}
