package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books; // 배열 선언
    private int last = 0; // 책의 마지막 위치, 책 꽂고 뽑으려면 위치 변수 필요

    public BookShelf(int maxsize) {
        // 배열 생성
        this.books = new Book[maxsize];
    }

    // 책을 꽂는 메소드
    public void appendBook(Book book) {
        // 인자로 들어온 책을 books라는 배열에 담아두기
        this.books[last] = book;
        last++;
    }

    // 책을 꺼내오는 메소드 //인자로 인덱스 책 위치
    public Book getBookAt(int index) {
        return books[index];
    }

    // 책 개수 리턴 메소드
    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIteratorBackward(this);
    }
}
