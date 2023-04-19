package ch10.practice;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random; // 랜덤 임의의 수 생성하기
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    } // seed가 같으면 동일한 숫자 생성

    @Override
//    요기가 winninfStrategy 핵심
    public Hand nextHand() {
        if (!won) { // 직전에 졌으면
//            prevHand 이번에 내민 손 보관해서 갖고 있기
            prevHand = Hand.getHand(random.nextInt(3)); //0,1,2 중 하나
        }
        return prevHand; // 직전에 이겼으면 그대로 같은 손을 리턴함.
    }

    @Override
    public void study(boolean win) {
        won = win; // 트루면 트루 담기고 폴스면 폴스 담김
//        직전에 이겼는지 졌는지를 여기서 이용함.
    }
}
