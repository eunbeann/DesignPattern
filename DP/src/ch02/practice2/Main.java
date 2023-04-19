package ch02.practice2;

//클라이언트
public class Main {
    // jvm입장에서는 아래 코드가 인터페이스임 여기서부터 시작
    public static void main(String[] args) {

        // // 가정 : 클라이언트가 직접 Banner를 사용하지 못한다.
        // Banner를 수정하면 클라이언트가 영향을 받는다
        Banner b = new Banner("keb");
        b.showWithParen();
        b.showWithAster();

        // 클라이언트는 Print 인터페이스를 이용하기를 원한다.
        // 이미 다른 클라이언트가 Print를 사용해서 개발을 진행해왔기 때문에....
// 어댑터의 인터페이스는 프린트다...?
        // 장점1. Banner를 수정해도 클라이언트는 영향을 안 받는다 (어댑터가 끼워져있기 때문에)
        // 장점2. Banner를 수정하지 않고도 Print처럼 사용했다.

        Print x = new PrintBanner("권은빈");

        x.printWeak();
        x.printStrong();

    }

}
