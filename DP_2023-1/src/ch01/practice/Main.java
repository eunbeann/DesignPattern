package ch01.practice;

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

        bs1.appendBook(b1);
        // Book result1 = bs1.getBookAt(0); // b1이 0번째에 꽂혔을테니까 0번째에서 가져와라~
        // System.out.println(result1.getName());

        bs1.appendBook(b2);
        // Book result2 = bs1.getBookAt(0); // b1이 0번째에 꽂혔을테니까 0번째에서 가져와라~
        // System.out.println(result2.getName());

        // for 루프를 이용해서 책 이름 출력하기
        // ~책 개수보다 작거나 같을때까지 돌리기
        for (int i = 0;; i++) {
            System.out.println(bs1.getBookAt(i).getName());
            // bs1.getBookAt(i)의 리턴 타입이 Book이니까

        }
    }

}