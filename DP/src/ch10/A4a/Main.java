package ch10.A4a;

import java.util.*;


//클래스도 따로 안만들고 간단하게 해결함 ㄷㄷ

//A4b는 더 간단함

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        list.sort(new Comparator<String>() {
            public int compare(String a, String b) {
//               람다식에서는 메소드 바디를 직접 넣어주기
                return a.compareTo(b);
            }
        });
        System.out.println(list);

        // 사전순으로 큰 순서
        list.sort(new Comparator<String>() {
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(list);
    }
}
