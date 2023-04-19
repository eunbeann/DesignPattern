package ch04.A2.idcard;


import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;

import java.util.Hashtable;

public class IDCardFactory extends Factory {
    private Hashtable manager = new Hashtable<>();
//    초기값 100
    private int serial = 100;

//    다음 아이디카드는 101번~, 사용자와 시리얼번호 추가하는 부분, 몇 번이 누군지까지 관리하진 않네 ㅎ
    protected synchronized Product createProduct(String owner) {
        manager.put(serial, owner);
//        생성하면, 시리얼 번호와 오너를 매니저에 먼저 넣어두고 생성해서 주면, 나중에 몇 번이 오너인지 얻어낼 수 있음
//        owner = manager.get(serial); => 하면 오너 나오게
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
