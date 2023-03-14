package hw.ch01;

public class Book {
    // 속성
    private String name = ""; // 책 제목, 변수 선언시에 초깃값 null값 주기
    private String author = ""; // 저자 제목, 변수 선언시에 초깃값 null값 주기

    // 생성자
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // 책, 작가 이름 얻어가는 메소드
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

}