package ch12.Sample;

public class StringDisplay extends Display {

  private String string; // 표시 문자열

  public StringDisplay(String string) {
    // 생성자는 스트링 받아서 자기 속성으로
    this.string = string;
  }

  @Override
  public int getColumns() {
    // Strin의 Length 리턴해주기
    return string.length();
  }

  @Override
  public int getRows() {
    // 스트링 한 줄짜리니까
    return 1; // 행수는 1
  }

  @Override
  public String getRowText(int row) {
    // 한줄짜리라 위치는 0번, 0이 아닌거 달라하면 에러 뜨게
    if (row != 0) {
      throw new IndexOutOfBoundsException();
      // 예외 객체 -> 클라이언트한테 가기 (이거 호출한 애한테)
    }
    return string;
  }
}
