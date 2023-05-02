package ch16.A1;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    // Mediator를 설정한다 
    @Override
//    메디에이터 받아서 자기 속성에 담기
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
//    지시 받을 때 호출되는 메서드 트루/폴스 들어오면 그대로 셋 인에이블드 호출에 넣어주기
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled); // 부모인 Button으로부터 상속받은 메소드
//        활성화 여부 설정하는 거 true -> 황성화 / false -> 비활성화
//        지시 받은 그대로 동작하고 있음을 알 수 있다!!
    }
}
