package ch02.practice2;

// 어댑터 : 위임을 이용함 -> 어떤 클래스가 다른 클래스를 속성으로 가짐
// Pritn  추상 클래스니까 extends 써줌
public class PrintBanner extends Print {
    // 어댑티를 갖는 속성
    private Banner banner; // 220qhfxm

    public PrintBanner(String string) {
        // 생성자는 속성. 어쩌고
        this.banner = new Banner(string);

    }

    // 구현해야하니까 abstric 키워드 지우기

    public void printWeak() { // 12볼트 인터페이스 : 클라이언트가 원하는 것
        // 안에서 220볼트로 바꿔줘야함 : 배너가 제공하니까!
        // 호출되면 adaptee에게 일시키기
        banner.showWithParen(); // 220볼트 (위임)

    };

    public void printStrong() {
        banner.showWithAster();

    };

}
