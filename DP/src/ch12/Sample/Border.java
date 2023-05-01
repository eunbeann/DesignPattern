package ch12.Sample;

public abstract class Border extends Display {

  // 구체적인 장식장의 부모
  //   누구든지 가리킬 수 있다.
  protected Display display; // 이 장식틀이 감싸는 '내용물(장식 대상))'을 가리키는 속성

  // 추상클래스 생성자는 디스플레이 속성에 달아두기
  //   객체 생성 안외는건데 어케했음? 디스플레이
  //   디스플레이 상속받아서 디스플레이 속성
  protected Border(Display display) { // 인스턴스 생성 시 '내용물'을 인수로 지정
    this.display = display;
  }
}
