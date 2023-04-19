package ch02.practice1;

// vendor class (이미 제공되어 있는 것, 220v)
public class Banner {
    private String string;
    // 문자열을 하나 가지고 있는 클래스

    public Banner(String string) {
        this.string = string;
    }

    // 자신이 가지고 있던 스트링 괄호로 출력하는 패턴
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    // Aster로 양쪽을 감싸는 패턴
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
