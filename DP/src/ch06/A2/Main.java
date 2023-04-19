package ch06.A2;

import ch06.A2.framework.Manager;
import ch06.A2.framework.Product;

public class Main {
    public static void main(String[] args) {
        // 準備
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        // 登録
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 生成と使用
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");

        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");

        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");

        //04/06 복사 생성자 이용하기

        MessageBox copy = new MessageBox(sbox);
//        s박스의 카피 만들기 복사 생성자로 하면 에스박스와 동일 값을 갖는 박스 ㅅㅇ성
        copy.use("Duksung"); // 복사 생성자로 s 박스와 동일한 거 해서 만들기

    }
}
}
