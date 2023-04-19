package ch04.practice.idcard;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
//    실제 등록은 해시맵에 키랑 등록할텐데 간단하게 하려고 여기선 출력만.
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}

//구체적 공장인 자식이