package ch11.A2;

public abstract class Entry {
    // 자기 부부모를 가리킴 :그래야지 부모가 누군지 알고 쭉 출력함.
    // eNtry 타입으로 부모를 가리킴: 사실 부토는 dir 이라 디렉토리 타입으로 써도 돼
    private Entry parent;

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // 이름을 가져온다 
    public abstract String getName();

    // 크기를 가져온다 
    public abstract int getSize();

    // 목록을 표시한다 
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여 목록을 표시한다
    protected abstract void printList(String prefix);

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // 전체 경로를 가져온다 
    public String getFullName() {
        // 부모 이름 앞쪽으로 끼워 넣으려고
        // 계속 내용이 바뀌;는 string 만들려고, 
        StringBuilder fullname = new StringBuilder(); // 문자열 구축을 위한 객체

        // 엔트리가 현재 객체를 가리키게 함
        Entry entry = this;
        do {
            // index : 0 
            fullname.insert(0, entry.getName()); // 현재 객체의 이름을 맨 잎에 삽입한다.
            // 부모의 이름 얻어짐. 슬래시 삽입함

            fullname.insert(0, "/");
            // entry 변수는 현재 노드를 가리킴 
            entry = entry.parent; // !! 현재 위치(포인터)를 부모로 옮긴다. !!  : 이거 잘 생각해보기
        } while (entry != null); /// entre가 null이 아닐 때까지 반복한다. : 루트까지 올라감 (부모가 더 이상 없으면 루프를 빠져나온다.)
        return fullname.toString();
    }
}
