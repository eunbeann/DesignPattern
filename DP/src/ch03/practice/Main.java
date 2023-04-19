package ch03.practice;

public class Main {
    public static void main(String[] args) {

        // LSP 원칙이 잘 지켜진 코드

        AbstractDisplay x;

        x = new CharDisplay('a'); // 캐릭터디스플레이 객체 만들기
        x.open();
        x.print();
        x.close();

        x.display();

        x = new StringDisplay("권은빈");

        x.open();
        x.print();
        x.close();

        x.display();
    }
    // 부모나 자식이다 다
}
