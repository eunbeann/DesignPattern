package ch10.practice;

import java.util.Random;

public class ProbStrategy implements Strategy {
//    더 머리를 쓰는 전략
//    임의의 수를 필요로 해서
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;

//    대괄호가 두개임 => 2차원 배열 (평면을 나타내는 좌표처럼)
    private int[][] history = {
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
//        직전 손 행을 다 더하면 직전 이긴 걸 이용해서 임의의 숫자 만들기
//        [0][x] getsum은 15
        int handvalue = 0; //초기화 0

//        어느 구간에 속하는지 결정해서 handvalue 결정
//        bet이 현재 나온 숫자, 현재 나온 숫자가 history에 있는 주먹 내고 0,
        if (bet < history[currentHandValue][0]) { // 첫번째 구간
//            췃번째 구간에 해당하면 0을 핸드 구간에 넣는다.
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) { // 두번째 구간
//            두번째 구간에 해당하면 1을
            handvalue = 1;
//            세번째 구간에 해동하면 2를
        } else { //세번째 구간
            handvalue = 2;
        }

//        직전 손 두 개 관리
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
//        손 요청하면 손 나옴
        return Hand.getHand(handvalue);
    }

    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
//            for loop 돌면 i가 0 1 2 로 변화
            sum += history[handvalue][i]; // handvalue 행을 다 더함을 getsum에서 하기
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHandValue][currentHandValue]++; //이겼으면 1 더하기
        } else { //졌으면 current value 아닌 곳 1 더하기 0바꿔줘야해서 나머지 3 이겼으면 이긴 곳에 1 더하거 졌으면 나머지 칸에 1 더한다.
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
