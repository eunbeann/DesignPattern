package ch04.practice.idcard;

import ch04.practice.framework.Product;

// 프로덕트 상속 받아 만들어짐
public class IDCard extends Product {
    private String owner;

//   package visibility ( 앞에 아무것도 없음 : 같은 패키지 속하는 애들만 볼 수 있는 )
    IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
//    this : 현재 id card 객체 : IDCard type,
//    문자열 + ID card 객체를 더하라고하면, 문자열은 문자열 연결로 + 사용, 문자열 연결을 위해서 this.toString()이 호출됨
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
//    id카드 오너를 사용합니다. 출력될 것
//    부모에 없는데 어케 물려받은거임? => 모든 클래스의 부모인 Object 클래스로부터 상속
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
