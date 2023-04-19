package ch10.practice;


public class Player {
//    초기화 습관 둘이기 !!
    private String name="";
//
    private Strategy strategy; //현재 전략을 보관 (부모 타입으로 선언_ (여러 strategy 보관 가능)
    private int wincount=0;
    private int losecount=0;
    private int gamecount=0;

    // 이름과 전략을 받아서 플레이어를 만든다 
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    // 전략에 따라 다음 손을 결정한다
    public Hand nextHand() {
        return strategy.nextHand();
    }
//    !! 자기가 손을 결정하지 않고 현재 전략 객체에게 위임함. !! 중요 (내가 하는 게 아니고 전략 객체가 함)
//    strategy가 뭘 갖고 있느냐에 따라 달라짐!!
//    부모 타입으로 선언되어 자식 어느 것이든

    // 승리
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    // 무승부 
    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        return "["
            + name + ":"
            + gamecount + " games, "
            + wincount + " win, "
            + losecount + " lose"
            + "]";
    }

//    전략을 교체하는 메소드
    public void setStrategy(Strategy s) {
        this.strategy = s;
//      기존 스트레터지가 인자로 들어온 스트레터지로 바뀜
    }
}
