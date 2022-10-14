package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("\"Pride and prejudice\"", 357);
        Book book2 = new Book("\"Clean code\"", 0);
        Book book3 = new Book("\"Thus Spake Zarathustra\"", 626);
        Book book4 = new Book("\"Faust\"", 488);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " has " + books[i].getPages() + " pages.");
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " has " + books[i].getPages() + " pages.");
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if ("\"Clean code\"".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " has " + books[i].getPages() + " pages.");
            }
        }
    }
}
