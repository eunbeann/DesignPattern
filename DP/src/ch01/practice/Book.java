package ch01.practice;

public class Book {
    // 속성
    private String name = ""; // 책 제목, 변수 선언시에 초깃값 null값 주기

    // 생성자
    // 전구 > generate Construc >
    public Book(String name) {
        this.name = name;
    }

    // 메소드
    // 책 이름 얻어가는 메소드
    public String getName() {
        return name;
    }
}