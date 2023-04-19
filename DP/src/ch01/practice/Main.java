package ch01.practice;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 책 생성
        Book b1 = new Book("book1");
        Book b2 = new Book("book2");

        // System.out.println(b1.getName()); 생성 확인

        // 책 부모 지정안하면 항상 오브젝트 상속 받음
        // snippet -> sysout

        // 책 꽂이 생성
        BookShelf bs1 = new BookShelf(10);// 책 열권 꽂는 책꽂이

//        책 꽂기
        bs1.appendBook(b1);
        // Book result1 = bs1.getBookAt(0); // b1이 0번째에 꽂혔을테니까 0번째에서 가져와라~
        // System.out.println(result1.getName());

        bs1.appendBook(b2);
        // Book result2 = bs1.getBookAt(0); // b1이 0번째에 꽂혔을테니까 0번째에서 가져와라~
        // System.out.println(result2.getName());

//        두 권의 책 꽂아서 아래에서 책 이름 출력해보기

        // i가 책 개수보다 작거나 같을때까지 돌리기
        System.out.println("for 루프를 이용해서 책 이름 출력하기");
        for (int i = 0; i<bs1.getLength(); i++) {
//            직접 접근했을 경우 영향을 받음
            System.out.println(bs1.getBookFrom(i).getName());
        }
            // bs1.getBookAt(i)의 리턴 타입이 Book이니까
//            exception 발생, mainmethod에서 발생하는 nullpointexception 발생 :
//            우리가 프로그래밍을 하면, 객체 "변수"가 있고, 객체 변수(주소를)를 따라가면 진짜 객체가 있음 nullpointexceoption은 변수 따라갔더니 아무것도 없는 경우임
//            결국은 객체가 없다~! 객체가 없는데 일해라 하는 경우를 말함. 우리가 잘 생각해보면 어디까지 돌아갈지 할 때bs1.getLength()에서 이퀄의 필요여부 잘 생각해봐야함.
//            0,1일 때 두 권을 꽂음. 자바에선 -1, =여부를 신경써야함. i가 0일때, 1일때 책 두 권인데 i가 2일엔 책 없음. i가 2일때 인덱스 2에 해당하는 값은 없는데 i를 2까지 돌리니까 이퀄을 빼던가, getLength()-1 을 해서 해결한다. 이젠 널포인트익셉션 안뜸.

        // 확장 for 루프를 이용해서 책 이름 출력하기
//        for문 콜론 오른쪽엔 집합체 왼쪽에는 원소하나씩 꺼내올 떄사용하는 b라는 변수
        System.out.println("확장 for문 사용하기");
        for ( Book b: bs1) {
           System.out.println(b.getName());  // 책 한권씩 접근
        }



//            iterator를 이용해서 책 이름 출력하기 : 클라이언트먼저 생각해보자
//            1. 아이터레이터 얻기, 2. 아이터레이터 이용해서 원소 얻어오기
            // iteraotor 얻기
//            책 꽂잉
            System.out.println("<book list using iterator>");
//        자바 프로그래밍씨 타입 잘 맞춰줘야함. 아이터레이터 타입 바꿨으니까 바뀐거로 다시 해줘야함
        Iterator<Book> iterator= bs1.iterator();
//           BookShelfIterator iterator = bs1.iterator();
//            책꽂이에 아이터레이터를 얻어가는 메소드랑, 아이터레이터를 하나 더 만들어야함. 아이터레이터에 넥스트 또 구현해줘야함.
            // iterator 이용해서 원소 얻어옴
//                    아이터레이터 항상 아래와 같은 형식, 책 더 잇으면 책 억어옴
            while(iterator.hasNext()) {
                Book b = iterator.next();
//                클라이언트는 아이터레이터한테 넥스트만 호출하면 다음 원소 얻어짐
                System.out.println(b.getName());
            }

            // 문자열 리스트 다루기,
            // 컬렉션: List(주르륵 줄세우기), Set(중복 없을 떄), Map(key,value 쌍으로) : 인터페이스명
            //ArrayList(인터페이스 구현 클래스)
            //부모 타입으로 줘기 (List), 문자열 리스트 만들기
        List<String> slist = new ArrayList<String>();
            slist.add("a");
            slist.add("b");
            slist.add("c");

        // 모든 원소 출력하기

        //1. for 루프 이용하기
        System.out.println("for 루프 이용하기");
//        i는 0,1,2 니까 3일떄 빠쟈나오도록 부등호 없이

        for(int i =0; i <slist.size(); i++) {
            System.out.println(slist.get(i));
        }
        System.out.println();

            //2. 확장 for 문 이욜하기
        System.out.println("확장 for문 사용하기");

        for (String s : slist) {
            System.out.println(s);
        }

        //3. Iterator 이용하기
        System.out.println(" Iterator 이용하기");
        // 3.1. iterator 얻기
        Iterator<String> it = slist.iterator();
        // 3.2. 원소 얻어오기
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        //4. 스트림 이용하기
        System.out.println(" 4. 스트림 이용하기"); //이거 잘 쓰면
        // 시냇물에 둥둥 떠오니까 처리만 해주기
        slist.stream().forEach(System.out::println); //원소 하나에 대해서 이 일을 하는지 // 메소드 참조

        }
    }