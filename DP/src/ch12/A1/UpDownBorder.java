package ch12.A1;

public class UpDownBorder extends Border {
    private char borderChar;  // 장식 문자 

    // 내용물이 될 Display와 장식 문자를 지정
//    장식 대상
    public UpDownBorder(Display display, char ch) {
        super(display);
//        장식할 문자 담기
        this.borderChar = ch;
    }

    @Override
//    컬럼 수 몇?
    public int getColumns() {
        // 문자 수는 내용물의 문자 수와 같다
//    업다운보더한테 칼럼수가 몇이냐하면 몇 주면 돼? => 내용물의 컬럼스하면 돼
        return display.getColumns();
    }

    @Override
//    row 수 몇?
    public int getRows() {
        // 행수는 내용물의 행수에 상하 장식 문자 수를 더한 것
//        내용물 위 아래 붙어있으니까 내용물의 행수에다가 1 더하면 전체 행수 나옴
        return 1 + display.getRows() + 1;
    }

//    Hello가 내용문이고 하이픈으로 위 아래 둘러싸는게 업다운 보더가 하는 일

    @Override
    public String getRowText(int row) {
//        요청 로우수가 전체 로우 수 -1 이면 : makeLine에서 줄을 만드는데 캐릭터만큼 줄을 만든다.
        if (row == 0 || row == getRows() - 1) {
            // 맨 위와 맨 아래는 장식 문자만의 행
            return makeLine(borderChar, getColumns());
        } else {
            // 내용물의 행(맨 위 행수만큼 행 번호를 줄인다
            return display.getRowText(row - 1);
        }
//        사이드 보더랑 원리는 동일함
    }

    // 문자 ch로 count 수만큼 연속한 문자열을 만든다
    private String makeLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < count; i++) {
            line.append(ch);
        }
        return line.toString();
    }
}
