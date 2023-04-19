package ch03.practice;

import ch03.practice.AbstractDisplay;

public class StringDisplay extends AbstractDisplay { //문자열 출력하는 애
    private String string;  // 표시해야 하는 문자열 
    private int width;      // 문자열의 길이 (문자열 폭

    // 생성자 : 스트링받아서 담아두기
    public StringDisplay(String string) {
        this.string = string;
        this.width = string.getBytes().length; //길이를 width에 한글일 때 수정
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    // open과 close에서 호출되어 "+----+" 문자열을 표시하는 메소드
    private void printLine() {
        System.out.print("+");

        // 하이픈을 width만큼 ( 글자수 만큼 )
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }

        System.out.println("+");
    }
}
