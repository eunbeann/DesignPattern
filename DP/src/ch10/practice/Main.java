package ch10.practice;

public class Main {
    public static void main(String[] args) {
////        바위
//        Hand h1 = Hand.ROCK;
////        h1이 Hand 타입 , 다른 점은 상수를 넣을 수 있다는 것
////        어느 enum class에 있는 상수인지 지정해주기
//        System.out.println(h1.toString());
//
////        1: 가위 2:보자기
//        Hand h2 = Hand.getHand(2);
//        System.out.println(h2);
//
////        h1이 h2를 이기는 지 승부 확인하기
//        if (
//                h1.isStrongerThan(h2)
//        ) {
//            System.out.println("h1이 이김");
//        } else if (h1.isWeakerThan(h2)) { //h2.isStrongerThan(h1)
//            System.out.println("h2가 이김");
//        } else {
//            System.out.println("무승부");
//        }
//
////        winning Strategy 잘 만들어졌는지 확인하기...?! (테스트)
//        WinningStrategy ws1 = new WinningStrategy(518);
////        strategy환테 졌다고 알려줌. -> 그럼 넥스트ㅡ핸드 새로 만들테니
//        ws1.study(false);
////        원할 때 넥스트 핸드 달라까
//        Hand wsh1 = ws1.nextHand();
//        System.out.println(wsh1);
//
//        ws1.study(true); // 이번엔 이겻서 알려주기
//        wsh1 = ws1.nextHand();
//        System.out.println(wsh1);
////        이겼다고하고 다시 뽑으면 똑같은 손 나와야 함
//
////        클래스 만들고 나서 잘 동작하는지 확인하고 다음 진행하기
//    }

//        게임 진행
//        1. 플레이어 생성 (strategy 이용)
//        객체 생성할 떄 무슨 전략 쓸지 결정하기
        Player p1 = new Player("권은빈", new ProbStrategy(100));
        Player p2 = new Player("유다영", new WinningStrategy(200));
//        context라고 하는 플레이러일때 어느 스트레터지 할지 결정, 나는 ProbStrategy / 쟤는 Winningstrategy

        p2.setStrategy(new ProbStrategy(300)); //전략을 동적으르 교체하기.(실행하면서 바뀐다)
//        다영이가 winning으로 만들어졌는데 스트레터지 교체 메서드를 이용해서 바꿀 수도 있음
//        알고리즘 하나하나를 strategy ㅠㅐ턴으롬 ㅏㄴ들고 교체할 수 잇다.

//        2. 게임 시작
//        가위바위보 여러번 시키기 : 여기서 for 시작해야 손 계속 바뀐
        for (int i = 0; i < 100000; i++) {
            Hand h1 = p1.nextHand(); //첫번째 플레이어의 손 얻기
            Hand h2 = p2.nextHand();

            if (h1.isStrongerThan(h2)) {
                System.out.println("Winner" + p1); //상황 프린팅
//            승패 알려주기
                p1.win();
                p2.lose();
            } else if (h1.isWeakerThan(h2)) {
                System.out.println("Winner" + p2);
                p1.lose();
                p2.win();

            } else {
                System.out.println("Even...");
                p1.even();
                p2.even();
            }
        }
        System.out.println("Total Result: ");
//        내가 더 좋은 전략 써서 내가 이김 ㅎㅎ
        System.out.println(p1);
        System.out.println(p2);
    }
}
