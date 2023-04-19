package ch01.practice;

import java.util.Iterator;

public class BookShelfIterator implements Iterator<Book> {

    BookShelf bookShelf; //"집합체" 자신이 돌아다닐 집합체 가지고 잇어야함. 이 집합체는 생성자에서 생성될 때 연결됨.
    int index ; //인덱스 값 초기화 해주기 여기서 =0해도 되고 생성자에서

    //        생성자 만들어주기
    public BookShelfIterator(BookShelf bookShelf) {
//        아이터레이터는 집합체 접근해서 하나씩 꺼내와야 하니까
//        이 경우는 북쉘프 접근해서 책 꺼내오기 그래야지 불쉘프아이터레이터는 북쉘프에 접근 가능
//        생성자
//        북 쉘프 아이터레이터와 북쉘프 연결
        this.bookShelf = bookShelf;
        this.index = 0; //인덱스 값 초기화

    }

//    next랑 hasnext 쓰기로 약속함
//    꺼내올 책이 더 있는지 검사하는 메소드 필요 : 모든 아이터레이터엔 이거 제공 됨
    @Override
    public boolean hasNext() {
//        인덱스가 끝에 도달하면 책이 더 없음
//        책 두권이면 겟렝스 2, index가 2보다 작으면 꺼내올 책 이있고 그렇지 않으면 꺼내올 책이없다.
        if(index < this.bookShelf.getLength()){
            return true;
        } else {
            return false;
        }
    }


//    다음 책을 반환하는 메소드
//클라이언트 입장에서 넥스트 호출하면 학상 책 반환해야하므로 리턴 타입은 책
    @Override
    public Book next() {
//        인덱스를 하나씩 증기시켜ㅕ가면서 리턴해줘야지 그 다음 책 그 다음 책 진행 가능
        Book book = this.bookShelf.getBookFrom(index);
//        인덱스 증가시켜 넥스트 호출마다 그 다음 책 그 다음 책 리턴해주기
        index ++;
// 책 리턴 시켜주자
        return book;
    }
}

//iterator rngus RMx~
//책 더 잇는지 검사하는 메소드
//그 다음 책 꺼내오는 메소드