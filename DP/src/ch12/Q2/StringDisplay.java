package ch12.Q2;

public class StringDisplay extends Display {
    private String string; // 표시 문자열 

    public StringDisplay(String string) {
//        1층짜리 스펀지 케이크만 중심으로 쓸 수 있었음!
//        예제 문제 2번에서는 중심 역할로 여러개 : 여러층 스펀지 케이크 만들거임
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1; // 행수는 1
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}
