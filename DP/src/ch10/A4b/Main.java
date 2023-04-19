package ch10.A4b;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

//         사전순으로 작은 순서
//        람다식을 이용함
//        Funtinal Interface: 메소드가 한 개 만 선언되어 있는 인터페이스
//        Funtinal Interface 들어갈 자리에 람다식을 넣을 수 있다 !! => 이거 알면 코딩 간단해져~
//       Comparator 인터페이스 functional 인터페이스이다.
        list.sort((a, b) -> a.compareTo(b)); //compare 메소드 바디를 제공한 것과 같음
//        결국 메소드 바디가 컴페어 메소드에 해당함
//        하나 밖에 없으니까 콤페어 해당
        System.out.println(list);

        // 사전식 순으로 큰 순서
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);
    }
}
