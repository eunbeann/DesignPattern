package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        //ARrray에 asList 호출헤서ㅏ 원소 주면 문자열 리스트로 만들어줌
//        문자열 다섯개 담는 리스트로 만들어
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서 (오른차순)

//        행동을 바꿀 수 있다 ! strateg pattern
//        list: 전략을 가지는 컨텍스트
//        comparator 전략에 해당

//        리스트한테 소팅 요총
//        comparator 오름차순 / 내림차순 줄 수 있 음
        list.sort( new ComparatorAscending() );
        System.out.println(list);

//        // 사전순으로 큰 순서 (내림차순)
        list.sort( new ComparatorDescending() );
        System.out.println(list);
    }
}
