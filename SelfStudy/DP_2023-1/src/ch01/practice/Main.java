package ch01.practice;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // 책 생성
        Book b1 = new Book("book1", "author1");
        Book b2 = new Book("book2", "author2");
        Book b3 = new Book("book3", "author3");
        Book b4 = new Book("book4", "author4");
        Book b5 = new Book("book5", "author5");
        Book b6 = new Book("book6", "author6");

        // System.out.println(b1.getName()); 생성 확인

        // 책 부모 지정안하면 항상 오브젝트 상속 받음
        // snippet -> sysout

        // 책 꽂이 생성
        BookShelf bs1 = new BookShelf(10);// 책 열권 꽂는 책꽂이

        bs1.appendBook(b1);
        // // Book result1 = bs1.getBookAt(0); // b1이 0번째에 꽂혔을테니까 0번째에서 가져와라~
        // // System.out.println(result1.getName());

        bs1.appendBook(b2);
        // // Book result2 = bs1.getBookAt(0); // b1이 0번째에 꽂혔을테니까 0번째에서 가져와라~
        // // System.out.println(result2.getName());
        bs1.appendBook(b3);
        bs1.appendBook(b4);
        bs1.appendBook(b5);
        bs1.appendBook(b6);

        // 명시적으로 Iterator 사용하기
        Iterator<Book> it = bs1.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName()+", "+book.getAuthor());
        }
        System.out.println();

        // 확장 for문 사용하기
//        for (Book book : bs1) {
//            System.out.println(book.getName());
//        }
//        System.out.println();
    }

}