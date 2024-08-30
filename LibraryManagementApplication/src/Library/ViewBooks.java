package Library;

import java.util.ArrayList;

public class ViewBooks implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        ArrayList<Book> books = database.getAllBooks();

        // Define column widths
        int nameWidth = 15;
        int authorWidth = 10;
        int publisherWidth = 15;
        int addressWidth = 10;
        int statusWidth = 10;
        int qtyWidth = 5;
        int priceWidth = 7;
        int brwCopiesWidth = 10;

        // Print header
        System.out.printf("%-" + nameWidth + "s%" + authorWidth + "s%" + publisherWidth + "s%" + addressWidth + "s%" + statusWidth + "s%" + qtyWidth + "s%" + priceWidth + "s%" + brwCopiesWidth + "s%n",
                "Name", "Author", "Publisher", "CLA", "Status", "Qty", "Price", "Brw cps");

        // Print each book's details
        for (Book b : books) {
            // Handle null values gracefully
            String name = b.getName() != null ? b.getName() : "N/A";
            String author = b.getAuthor() != null ? b.getAuthor() : "N/A";
            String publisher = b.getPublisher() != null ? b.getPublisher() : "N/A";
            String address = b.getAddress() != null ? b.getAddress() : "N/A";
            String status = b.getStatus() != null ? b.getStatus() : "N/A";

            // Print details with formatting
            System.out.printf("%-" + nameWidth + "s%" + authorWidth + "s%" + publisherWidth + "s%" + addressWidth + "s%" + statusWidth + "s%" + qtyWidth + "d%" + priceWidth + ".2f%" + brwCopiesWidth + "d%n",
                    name, author, publisher, address, status, b.getQty(), b.getPrice(), b.getBrwcopies());
        }

        System.out.println();
        user.menu(database, user);
    }

//    public void oper(Database database,User user) {
//        ArrayList<Book>  books=database.getAllBooks();
//        System.out.println("Name\t\tAuthor\t\tPublisher\tCLA\t\tStatus\tQty\tPrice\tBrw cps");
//
//        // Print each book with tabs
//        for (Book b : books) {
//            System.out.println(b.getName() + "\t\t" +
//                    b.getAuthor() + "\t\t" +
//                    b.getPublisher() + "\t\t\t" +
//                    b.getAddress() + "\t\t" +
//                    b.getStatus() + "\t" +
//                    b.getQty() + "\t" +
//                    b.getPrice() + "\t" +
//                    b.getBrwcopies());
//        }
//        System.out.println();
//        user.menu(database,user);
//    }
}
