package ch01.practice;

public class BookShelf {
    private Book[] books; // 배열일 땐 변수 이름 복수로 주기 // 배열 선언
    private int last = 0; // 책의 마지막 위치, 책 꽂고 뽑으려면 위치 변수 필요

    public BookShelf(int maxsize) {
        // 배열 생성 (배열은 선언과 생성 과정 필요)
        this.books = new Book[maxsize]; // 배열의 특징 : 배열 생성 시 크기 결정, 속도는 빠르지만 생성시 크기 고정
        // 생성될 때 사이즈 만들어서!! 일반화 될 수 있는지 고민하기
    }

    // 책을 꽂는 메소드
    public void appendBook(Book book) {
        // 인자로 들어온 책을 books라는 배열에 담아두기
        this.books[last] = book;
        last++;

    }

    // 책을 꺼내오는 메소드 // 인자로 인덱스 책 위치
    public Book getBookAt(int index) {
        return books[index];
    }
    // 책 개수 리턴 메소드

}
