package ch01.practice;

public class Main {

    public static void main(String[] args) {
        // 책 생성
        Book b1 = new Book("book1");
        System.out.println(b1.getName());
        // 책 부모 지정안하면 항상 오브젝트 상속 받음
        // snippet -> sysout
        System.out.println();
    }

}