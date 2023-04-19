package ch01.practice;

//JDK 제공 패키지에 있는 아이터레이터를 이용한다.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//JDK 제공 Iteralbe 인터페이스 쓰자
//Iterable<Book> : Bookshelf는 반복이 가능한데, 각 원소의 타입은 책이다를의미함., 책을 돌아다니는 ㅏㅇ이터러블
public class BookShelf implements Iterable<Book> {
//    private Book[] books; // 배열일 땐 변수 이름 복수로 주기 // 배열 선언

    //어레이리스트로 바꿔주기 =-> a1확인하기 전반적으로 코드가 간단해짐
    private List<Book> books = new ArrayList<Book> ();

    //    책 꽂이는 책을 포함하니까
    private int last = 0; // 정확히 말하면 다음에 꽂힐 책의 위치, 책의 마지막 위치, 책의 개수를 나타냄 책 꽂고 뽑으려면 위치 변수 필요

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
//    public Book getBookAt(int index) {
    public Book getBookFrom(int index) {
        return books[index];
    }

    // 책 개수 리턴 메소드
    public int getLength() {
//        책 한 권 꽂힐 때 마다 하나씩 증가하는 last가 책을 가짐
//        last-1이 될 수도 있음 -> 한권 꽂으면1이되고, 두권꽂으면2가 된다는 점 알고있기
        return last;
    }

    // iterator 반환하는 메소드
//    public BookShelfIterator iterator() {
//    인터페이스 썼으니까 더 일반적으로 바꿔주기 : 프로그램은 일반적으로 쓰는 게 좋으니까 책을 돌아다니느 아이터러블
    // 부모 즉 인터페이스에 정의된 메소드를 구현했기 때문에 @Override붙이면 > 부모에 선언된 것을 오버라이드 한 것이다 라고 표시함.
    // 표시해두면 좋은 점: 위 주석과 구분되어 부모쪽에서 온 메소드구나를 알 수 있음
    // @ : 어노테이션 지정 기호 > 이 경우에는 뭔가 표시를 해주는 역할을 함.

//    부모타입으로 선언하면 꼭 bookshelf iterator가 아니더라도
    @Override
    public Iterator<Book> iterator() {
//        북쉘프아이터레이터 반환
        return new BookShelfIterator(this); //현재 책꽂이와 iterator 연결됨.
//        bookshelf마다 아이터레이터 반환해주는 거 만들면 아이터레이터라만 일함.
//        책 꽂이 넣어줘야지 아이터레이터와 연결됨. => 현재 내 ㄱ책꽂이랑 연결하려고 this 넣어줌 this : 현재 객체
    }




}
