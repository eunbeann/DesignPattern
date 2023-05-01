package ch12.A2;

public class Main {
    public static void main(String[] args) {
        MultiStringDisplay md = new MultiStringDisplay();

        md.add("Hi!"); //내용물이기때문에
        md.add("Good morning.");
        md.add("Good night!");
//        삼층짜리 스펀지 케이크
        md.show();

        Display d1 = new SideBorder(md, '#');
//        내용물을 사이드보더로 장식
        d1.show();

        Display d2 = new FullBorder(md);
//        fullborder로도 장식해서 출력
        d2.show();
    }
}
