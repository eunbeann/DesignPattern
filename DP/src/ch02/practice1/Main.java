package ch02.practice1;

//클라이언트
public class Main {
    // jvm입장에서는 아래 코드가 인터페이스임 여기서부터 시작
    public static void main(String[] args) {

        // // 가정 : 클라이언트가 직접 Banner를 사용하지 못한다.
        Banner b = new Banner("keb");
        b.showWithParen();
        b.showWithAster();

        // 클라이언트는 Print 인터페이스를 이용하기를 원한다.
        // 이미 다른 클라이언트가 Print를 사용해서 개발을 진행해왔기 때문에....

        Print x = new PrintBanner("권은빈");

        x.printWeak();
        x.printStrong();

    }

}
