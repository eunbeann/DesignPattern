package ch12.A2;

import java.util.ArrayList;
import java.util.List;

// 제일 긴 거 기준으로 빈칸 채워야지 풀 보더, 사이드 보더에 줄이 맞음!!
// 이게 빈칸 채우는 알고리즘

public class MultiStringDisplay extends Display {

    // 표시 문자열 저장 장소, 문자열 여러 개 가져야하니까
    private List<String> body = new ArrayList<>();
    // 표시 문자열 최대 문자 수 
    private int columns = 0;

    // 문자열 추가 
    public void add(String msg) {
//        문자열 세 개를 어레이 리스트에 담음
//        뭐가 제일 긴지를 알아야지 빈칸 채울 수 있음
//        최대 문자열 몇 개인지... 7이라는 숫자 기억하기 -> 그 기억하기 위해서 변수 만들기 (columns)
        body.add(msg);

//        얘가 하는 일은... -> 더 긴 문자열을 넣는다면....
        if (columns < msg.length()) {
//            msg의 길이 검사
            // 최대 문자 수 갱신
            columns = msg.length();
//            colums를 지금 제일 큰 문자열로 업데이트 하기
        }
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
//        arraylist에 들어있는 문자열의 개수
        return body.size();
    }

    @Override
    public String getRowText(int row) {
//        그냥 어레이 리스트에 있는 거 줌 꺼내올 때 get으로 / 추가할때는 add
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) {
//            row가 0이면
            String line = body.get(row);

            int padding = columns - line.length(); // 채워야 할 빈 칸 갯수

            if (padding > 0) { // 빈 칸을 채워야 하면...
                body.set(row, line + spaces(padding)); // 빈칸  합쳐준거 다시 body에 set 해주기
            }
        }
    }

    // count 수만큼의 공백을 만든다 
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
//        스트링빌더 만들고 스트링빌더한테 추가
//        카운터만큼 빈칸
        return spaces.toString();
    }
}
