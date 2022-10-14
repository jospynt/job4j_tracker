package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book[] books = new Book[4];
        book1.setName("\"Pride and prejudice\"");
        book1.setPages(357);
        book2.setName("\"Clean code\"");
        book2.setPages(0);
        book3.setName("\"Thus Spake Zarathustra\"");
        book3.setPages(626);
        book4.setName("\"Faust\"");
        book4.setPages(488);
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
