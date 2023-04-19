package ch04.practice;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;
import ch04.practice.idcard.IDCard;
import ch04.practice.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
//        신분증 직접 생성
        Product id01 = new IDCard("keb");
//        신분증 사용
        id01.use();


//        신분증 공장을 통해 생성 : 공장.create()
//        Product id02 = 공장.create()

//        공장 만들기
        Factory f =  new IDCardFactory();

//        공장한테 create 생성
        Product id02 = f.create("keb");
        id02.use();

    }
}
