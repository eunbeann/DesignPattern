package ch16.A1;

public interface Colleague {
    // Mediator를 설정한다 - 메디에이터를 받아서 설정
    public abstract void setMediator(Mediator mediator);

    // Mediator에서 활성/비활성을 지시한다 (지시를 내릴 떄 호출하는 메소드 => 활성화/비활성화)
    public abstract void setColleagueEnabled(boolean enabled); //인자타입 불리언!! true => 활성화 false => 비활성화
}
