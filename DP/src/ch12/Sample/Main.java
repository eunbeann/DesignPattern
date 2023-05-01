package ch12.Sample;

public class Main {

  public static void main(String[] args) {
    // 중심을 생성
    // HrlloWor를 갖는 스트링
    Display b1 = new StringDisplay("Hello, world.");
    // 중심을 장식함, 장식한 결과물이내용물(장식 대상)이 될 수 있다.
    Display b2 = new SideBorder(b1, '#');
    // b2를 내용으로해서 FullBorder 장식
    Display b3 = new FullBorder(b2);

    // 장식 없는거
    b1.show();
    // sideobrder 장식
    b2.show();
    // fullborder 장식
    b3.show();

    Display b5 = new FullBorder(b1);
    b5.show();

    Display b6 = new FullBorder(b5);
    // FullBorder로 둘러싼 걸 다시 fullBorder로 감싸기 -> 무한히 둘러쌀 수 있음
    // 순서 바꾸기도 가능 다양한 장식으로 장식 가능

    Display b4 = new SideBorder(
      // 다시 사이더로
      new FullBorder(
        // 다시 풀보더로
        new FullBorder(
          // 다시 풀 보더로
          new SideBorder(
            // 그 결과를 사이드로
            new FullBorder(new StringDisplay("Hello, world.")),
            // 중심을 풀보더로 장식
            '*'
          )
        )
      ),
      '/'
    );
    b4.show();
  }
  //   장식 순서 바꿀 때마다 다양한 결과가 나와 다양한 장식이 가능하다.
}
