package ch11.practice;

import java.util.ArrayList;
import java.util.List;

// 그릇 역할을 함


// composite (그릇)을 나타냄 (그릇은 내용물을 담는다는 점이 달라서 내용을 담는다는 컬렉션 객체 있어야 함
public class Directory extends Entry {
    private String name;

//    자기 내용물 리스트를 관리하는 변수
    private List<Entry> directory = new ArrayList<>(); // Entry: 부모 타입 주목해서 보기
// 내용물 담으려고 array리스트


//    생성자는 이름 받아서 생상됨
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
//    자기 내용물의 getSize()를 호출함
//  자기 자식들의 사이즈를 계속 초대해서 총 사이즈를 호출함
    public int getSize() {
//        사이즈 초기화
        int size = 0;

//        확장 for 문 원소 하나씩 꺼내오는 원소
        for (Entry entry: directory) {
//            하나씩 꺼내와서 getSize 호출
            size += entry.getSize(); //재귀적 호출
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            // 자기 앞 경로 쭉 찍기
            entry.printList(prefix + "/" + name); // 재귀적 호출
            // 경로가 쌓임
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
//    부모 타입이라 파일 디렉토리 다 받아서 호출할 수 있다.
public Entry add(Entry entry) {
    directory.add(entry);
    // 디렉토리 추가될 때 추가되고 나서 현재 디렉토리를 추가할 자식의 부모로 설정한다.
    entry.setParent(this); // 부모를 현재 디렉토리로 설정한다. : this는 부모 . 
        return this;
    }
}
