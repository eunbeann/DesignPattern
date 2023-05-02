package ch16.A1;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
//    액션리스너 => 버튼 눌렸을 때 액션 이벤트 발생 이 이벤트 발생했을 시에 액션 리스너가 일을 함.
//    콜리그 버튼들이 눌리면 로그인 프레임이 일할 것
//    오케이버튼 클릭 시 액션 이벤트 발생 => 로그인프레임으로 전달되어 처리
//    창도 제공하고, 중재자 역할도 함.
//    Frame 클래스 상속 받아서 창 만듦
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
//    ^ 체크박스를 위한 속성 선언만 되어 있는 상태
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
//    ^ 텍스트 필드를 위한 속성 선언
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;
//    ^ 버튼을 위한 속성 선언
//    6개의 속성 선언 두 개씩 나눠보면

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
//         타이틀 불러와서 부모 생성자 호출: 이거 없으면 부모의 인자 없는 생성자 호출됨.
//         이거 있으면 부모 생성자 중에 타이틀 인자를 갖는 생성자 호출함. 이건 반드시 첫번째에 와야 함.
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // 활성/비활성 초기 설정을 한다 : 컴포넌트 추가하는 부분
        colleagueChanged();

        // 표시한다 두 가지 문장 꼭 실행하기
        pack(); // 컴포넌트들 호출하고 내부적으로 위치 같은 거 조정해줌
        setVisible(true); // 화면에 보이게
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox
//        그룹으로 묶고 상태 지정
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        // TextField
//        초기 문자열 null하고 10칸 짜리로 만든다.
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*'); // 입력했을 때 보여지는 문자열

        // Button
//        콜리그 버튼 두개 오케이/캔슬
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

//        ^^선언해서 속성으로 담기

        // Mediator를 설정한다 => 중재자 지정해주기 this => 로그인이 메디에티어 역할하니까
//        내가 중재자다!
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest); // 체크 박스의 리스터는 체크게스트다 둘이 똑같다는 말은 이벤트 발생하면 리스너가 되어서 동작핮나
        // 체크박스이면서 리스너 역할도 함
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
//    콜리그가 @@하고 @@@가 지시하고
    @Override
    public void colleagueChanged() {
//        제일 중요한 메소드 : 자기 상태가 바뀌면 중재자의 collegue Changed() 호출
//        어떤 상태가 바뀌었는지 보는 거임
        if (checkGuest.getState()) {
//         true, false 결과 나옴 => true면 게스트 라디오 버튼 눌린거, false면
            // 게스트 로그인
            // otextUser, textPass 비활성화
            textUser.setColleagueEnabled(false); // 비활성화 해라...
            textPass.setColleagueEnabled(false);// 비활성화 해라...
            buttonOk.setColleagueEnabled(true);// 활성화 해라...
        } else {
            // 사용자 로그인 
            textUser.setColleagueEnabled(true); // 너 활성화해라 지시내림
            userpassChanged(); // 유저 네임, 패스 들어간건 함수로 뺌
        }
    }

    // textUser 또는 textPass의 변경이 있다 
    // 각 Colleage의 활성/비활성을 판정한다
//    텍스트 유저(유저네임)부분이 겟 텍스트하면 저기 들어가 있는 텍스트를 얻어오면
    private void userpassChanged() {
        if (textUser.getText().length() > 0) { //username 칸에 문자열이 입력되어 있으면
            textPass.setColleagueEnabled(true);
             if (textUser.getText().length() >= 4 && textPass.getText().length() >= 4) {
//                 유저 네임 패스 워드 4보다 클 때만 오케이
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        액션 이벤트를 문자열로 찍고 exit :  호출
//        원랜 로그인 과정 구현해야할테지만 우린 껍데기만 있으니까

        System.out.println(e.toString());
        System.exit(0);
    }
}
