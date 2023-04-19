package ch10.practice;

// 열거형 클래스 => (변수의) 타입으로 사용가능함.
public enum Hand {
    // 가위 바위 보를 나타내는 세 개의 enum 상수
//    이름은 바위고 숫자로 나타내면 0이다.
//    상수가 있다는 게 다른 클래스오 다른 점 enum의
    ROCK("바위", 0),
    SCISSORS("가위", 1),
    PAPER("보", 2);

    // enum이 가진 필드 : hands가 가지는 속성
    private String name; // 가위 바위 보 손의 이름
    private int handvalue; // 가위 바위 보 손의 값 

    // 손의 값으로 상수를 얻기 위한 배열
//    스태틱으로 클래스에 속함. 핸드로 이루어진 배열
    private static Hand[] hands = {
        ROCK, SCISSORS, PAPER
    };

    // 생성자 
    private Hand(String name, int handvalue) {
        this.name = name;
        this.handvalue = handvalue;
    }

    // 손의 값으로 enum 상수를 가져온다 / 숫자를 받아서 해당하는 손 리턴 , 해당하는 상수가 리턴 됨
//    hands[0] => ROCK 이 리턴 됨
//    숫자를 넣어주면 손으로 리턴되는 일을 함.
    public static Hand getHand(int handvalue) {
        return hands[handvalue];
    }

    // this가 h보다 강할 때 true
//    손을 비교하기, 가위바위보니까 누구 손이 더 이기는지 비교하기
//    손 두 개 비교해야되는데 손 하나 있으니까, 나머지 하나는 this가 손임.
//    메소드 가진 주체가 손이니까 ..
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    // this가 h보다 약할 때 true
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    // 무승부는 0, this가 이기면 1, h가 이기면 -1
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }

    // 가위 바위 보의 문자열 표현
    @Override
    public String toString() {
        return name;
    }
}
