package ch12.Sample;

public abstract class Display {

  // 속의 내용물 몇줄, 몇칸인지 리턴해주는 메소드
  // 추상 메소드라 자식들이 구체적으로 구현해 나가야하는 메소드임
  public abstract int getColumns(); // 가로 문자 수를 얻는다

  public abstract int getRows(); // 세로 행수를 얻는다

  // 아랜느 여려 줄일 때 몇ㅈ번째줄
  public abstract String getRowText(int row); // row행째 문자열을 얻는다

  // 모든 행을 표시한다
  public void show() {
    // 전체 출력하기 (실제 내용물 추력))
    for (int i = 0; i < getRows(); i++) {
      // 행수보다 작을때까지 I번째 행 출력
      //   템플릿 메소드 쓰임
      System.out.println(getRowText(i));
    }
  }
}
