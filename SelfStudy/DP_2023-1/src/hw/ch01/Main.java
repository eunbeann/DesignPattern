package hw.ch01;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------------");
        System.out.println("20190508 권은빈");
        System.out.println("--------------");

        // 책 생성
        Book b1 = new Book("자료구조론", "박우창");
        Book b2 = new Book("소프트웨어분석설계", "최승훈");
        Book b3 = new Book("프로그래머수학", "이주영");
        Book b4 = new Book("컴퓨터동작원리", "유견아");
        Book b5 = new Book("컴퓨터그래픽스", "이경미");
        Book b6 = new Book("어린이라는 세계", "권은빈");

        // 책 꽂이 생성
        BookShelf bs1 = new BookShelf(10);

        // 책 꽂기
        bs1.appendBook(b1);
        bs1.appendBook(b2);
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

    }
}