package ch04.practice.framework;

import ch04.practice.framework.Product;

public abstract class Factory {
//    제품 생산 시 하는 큰 흐름 => 템플릿 메소드 (추상 메소드) , 제품 @@할때 어떤 일을 하는지에 대한 큰 흐름
    public final ch04.practice.framework.Product create(String owner) {
//        제품 만들고 : 이 단계들은 추상메소드고 구현은 자식들이 하게 됨
        ch04.practice.framework.Product p = createProduct(owner);
//        등록하고
        registerProduct(p);
//        리턴해줌
        return p;
    }

//    IDCardFactory에서 아래 두 개 구현하기
//    실제로 어떤 제품 (객체)를 생성할지는 자식에게 맡긴다. : 현재 패턴의 핵심 !!
    protected abstract ch04.practice.framework.Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}

//여기서는 제품 생산에 대한 스텝만 알고 어떤 걸 만드는지는 모름, 구체적인 제품 생산은 자식에게 맡기기