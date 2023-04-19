package ch02.practice1;

// 어댑터 : 상속을 이용함

// 프린트 구현함. 프린트 구현했다는 건 프린트 역할을 한다는 것을 알있음
// printweak, printstrong 호출 가능.

//프린트를 구현하고 배너를
//실제일은 배너가 하고, 어댑터는 인터페이스 전환만(이름 바꾸기)만 진행
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) { // 생성자
        // 생성자 안에서의 super는 부모 생성자를 의미함
        super(string);
    }

    @Override
    public void printWeak() { // 12볼트 요청
        showWithParen(); // 220볼트 : 실제 일은 Banner가 함
        // 가능한 이유는 어댑터가 배너라고하는 벤더 클래스를 상속 받았기 떄문
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
