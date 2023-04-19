package ch03.practice;

public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드
//    나는 이름만 정할테니 하위에서 내부 채워라 : 여긴 선언
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드
    //구상메소드인데 추상메소드로 구현
    public final void display() { //open 우선 호출 : 1번, 프린트를 5번 함, 클로즈 1번
        // 구상메소드, 흐름의 큰 틀을 제공함. => 템플릿 메소드 : 여긴 구현

//      추상 메소드들을 이용해서 구현 : 흐름의 큰 틀은 이쪽에서 진행하고
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
