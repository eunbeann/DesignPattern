package ch11.practice;

import Entry;

public class File extends Entry {
    private String name;
    private int size;

//    파일 이름과 크기를 갖는 파일 클래스

//    생성자
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
//    이름 가져오기

    @Override
    public String getName() {
        return name;
    }

//    사이즈 가져오기
    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
