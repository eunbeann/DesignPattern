package ch11.practice;

public abstract class Entry {
    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다 
    public abstract int getSize();

    // 목록을 표시한다 / 없으면 뭘 구현하는게 아니라 토스 함
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여서 목록을 표시한다 
    protected abstract void printList(String prefix);
//    같은 이름 타입 다르게 여러개 -> 오버로딩

    // 문자열 표시 
    @Override
    public String toString() { // 이름 찍고, 괄호 열고 사이즈 찍고 괄호 닫고 일함.
        return getName() + " (" + getSize() + ")";
    }
}
