package ch16.Sample;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;

    //    자기 중재자가 누군지 알기 -> 메디에이터 속성을 가지고 있음
//    콜리그 역할을 함. 지시 받을 때 메소드
//    텍스트리스너 -> 텍스트 이벤트에 대한 리스너 : 키보드 입력하면 텍스트필드 자체가 이벤트 처리하도록 구현 됨
    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }
//   두개 받아서 부모 생성자 호출하기 : 텍스트 필드 생성자 호출하기, 전달받은 텍스트 컬럼 같이 넣기

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
//    메디에이터 받아서 속성에 담아둠

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
//        중재자가 지시할 때 호출하는 메소드 : 활성화, 비활성화 지시
        setEnabled(enabled);
//        상속받은 메소드 setenable
        // 활성/비활성에 맞게 배경색을 변경한다 :true, 활성화(흰색) false 비활성화(회색)
//        부모로 물려받은 메소드 흰색 혹은 회색 배경
        setBackground(enabled ? Color.white : Color.lightGray);
    }

    @Override
    public void textValueChanged(TextEvent e) {
//        텍스트 이벤트 발생했을 때 동작함.
        // 문자열이 변화했으면 Mediator에 알린다
        mediator.colleagueChanged();
//        콜리그가 바뀌었다고 메디에이터한테 말해주기 문자 입력할때마다 실행되어서 중재자한테 통제가 감
    }
}
