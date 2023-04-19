package ch10.Q4;
import java.util.Comparator;

//오름차순 요청
//구현해줘야 컴패러터 됨
public class ComparatorAscending implements Comparator {
//    컴패러터 구현해주려면 컴패러터 인터페이스
    @Override
//    오름차순으로 정렬디도록 반환값 리턴해야 함
    public int compare(Object a, Object b) {
//        우리 스트링하고 싶은데 오브젝트로 선언되어 있음 ㅠ - 타입캐스팅으로 스트링으로 바꿔주기
//        두 개 크기 비교해줌
//        반환값 : 양수, 음수, 0
//        정렬 주체 (List)는 양수가 리턴되면 a와 b의 위치를 서로 바꾼다.
//        오름차순 작은 게 앞에 옴.  => compare 리턴할때
//        큰 게 앞으로 오면 양수 리턴 (뒤로 보내기)
        return ((String)a).compareTo((String)b); // 손 두 개 비교하듯이 a하고 b비교, "."이 우선순위가 가장 높다.
//        이제 위에 거 두 경우 생각해야 됨
//        a의 문자코드 - b의 문자코드 : 뒤에 있을수록 문자코드 큼.
//        a가 작은경우엔 음수가 리턴 됨.
//        a가 큰 경우에는 양수가 리턴 됨. => a와 b의 위치를 바꾼다. => 오름차순
    }
}



// 아래처럼도 쓸 수 있음 더 간단한 코드 : 실력 붙을 수록 코드 간단
//public class ComparatorAscending implements Comparator<String> {
//    @Override
//    public int compare(String a, String b) {
//        return (a).compareTo(b);
//    }
//}
