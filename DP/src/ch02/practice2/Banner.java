package ch02.practice2;

// 220볼트 (Adaptee)
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    // 메소드 프로토 타입
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
