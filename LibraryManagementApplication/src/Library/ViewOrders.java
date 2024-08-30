package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrders implements IOOperation{
    @Override
    public void oper(Database database,User user) {
        System.out.println("\nEnter book name");
        Scanner sc=new Scanner(System.in);
        String bookname=sc.next();
        int i=database.getBook(bookname);
        if(i>-1){
            System.out.println("Book\t\tUser\t\tOty\t\tPrice");
            //ArrayList<Order> orders=new ArrayList<Order>();
            for(Order order:database.getAllOrders()){
                if(order.getBook().getName().matches(bookname)){
                    System.out.println(order.getBook().getName()+"\t\t" +
                           order.getUser().getName()+"\t\t"+order.getQty()+"\t\t"+order.getPrice());
                }


            }

            System.out.println();
        }else{
            System.out.println("Book doesn't exist\n");
        }
        user.menu(database,user);
    }
}
