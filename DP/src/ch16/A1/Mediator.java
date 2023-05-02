package ch16.A1;

public interface Mediator {
    // Colleague를 생성한다 
    public abstract void createColleagues();
//    중재자가 콜리그 생성하고 중재하려고 생성하는 메소드

    // Colleage의 상태가 변화했을 때 호출된다 => 보고 받을 때 메소드
    public abstract void colleagueChanged();
//    콜리그 변화 발생시 이거 호출하면 적당한 일을 중재자가 함
}
