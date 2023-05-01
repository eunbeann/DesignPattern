package ch12.Sample;

public class FullBorder extends Border {

  // 장식자니까 보더 상속 받고
  public FullBorder(Display display) {
    // 부모 생성자 호출
    super(display);
  }

  @Override
  public int getColumns() {
    // 문자 수는 내용물 양쪽에 좌우 장식 문자만큼 더한 것
    return 1 + display.getColumns() + 1;
    // 내용물 컬럼수 2 더하면 장식장 됨
  }

  @Override
  public int getRows() {
    // 행수는 내용물의 행수에 상하 장식 문자만큼 더한 것
    return 1 + display.getRows() + 1;
  }

  // 이건 내용물 칸 수 줄 수 모두 늘어남

  @Override
  public String getRowText(int row) {
    // 이거 중요해~~
    if (row == 0) { // 상단 테두리 제일 윗 줄
      return "+" + makeLine('-', display.getColumns()) + "+";
      //   양쪽에 플러스 붙여서 만들어주기
    } else if (row == display.getRows() + 1) { // 하단 테두리 : 전체 줄수보다 하나씩 큼.
      return "+" + makeLine('-', display.getColumns()) + "+";
    } else { // 기타
      return "|" + display.getRowText(row - 1) + "|";
      //   1번행 달라고 하면 실제 내용물은 0번이라서 한 줄씩 줄어야 해
    }
  }

  // 문자 ch로 count 수만큼 연속한 문자열을 만든다
  private String makeLine(char ch, int count) {
    // 어떤 캐릭터로 몇 개만들지 전달받아서 만들기
    StringBuilder line = new StringBuilder();
    // 스트링 빌더 만들기
    for (int i = 0; i < count; i++) {
      line.append(ch);
      //   카운트 만큼 for loop 돌림
    }
    return line.toString();
    // 스트링 리턴
  }
}
