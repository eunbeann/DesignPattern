public enum Hand {
  // 가위 바위 보를 나타내는 세 개의 enum 상수;
  ROCK("바위", 0),
  SCISSORS("가위", 1),
  PAPER("보", 2);

  //enum이 가진 필드
  private String name;
  private int handValue;

  // 손의 값으로 상수를 얻기 위한 배열
  private static Hand[] hands = { ROCK, SCISSORS, PAPER };

  // 생성자
  private Hand(String name, int handValue) {
    this.name = name;
    this.handValue = handValue;
  }

  // t손의 값으로 enum 상수를 가져온다.
  public static Hand getHand(int handValue) {
    return hands[handValue];
  }

  //   this가 h 보다 강할 때 true
  public boolean isStrongerThan(Hand h) {
    return fight(h) == 1;
  }

  //   this가 h 보다 약할 때 true
  public boolean isWeakerThan(Hand h) {
    return fight(h) == -1;
  }

  public int fight(Hand h) {
    if (this == h) {
      return 0;
    } else if ((this.handValue + 1) % 3 == h.handValue) {
      return 1;
    } else {
      return -1;
    }
  }

  //   가위바위보의 문자열 표현
  @Override
  public String toString() {
    return name;
  }
}
