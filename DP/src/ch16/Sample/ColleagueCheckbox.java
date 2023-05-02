package ch16.Sample;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
//    체크 박스는 awt 패키지에 있는거
//    아이템 리스너가 있는걸 보니 : 발생하면 처리한다.
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
//        캡션은 문자열, 체크박스 그룹은 누구랑 그룹할거야 (게스트, 그룹 그룹인데 둘 중 하나만 체크되어야 하니까)
//        스테이트까지 받는데 , 스테이틑 선택될지 말지 true면 선택으로
        super(caption, group, state);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
//        메디에이터 받아서 설정하는 부분
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
//        지시받을 때 메소드 활성화 비활성화 실행
        setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // 상태가 변화하면 Mediator에 알린다
        mediator.colleagueChanged();
    }
}
