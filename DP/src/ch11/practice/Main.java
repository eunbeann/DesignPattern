package ch11.practice;

public class Main {

  public static void main(String[] args) {
    // Entry f1 = new File("vi", 100);
    // System.out.println(f1.getName());
    // System.out.println(f1.getSize());
    // System.out.println(f1);
    // 루트 디렉터리 생성
    Directory root = new Directory("root");
    // 타입은 -> 부모 타입 ENTRY / 실제 들어가는 객체는 ?!
    // bin
    Directory bin = new Directory("bin");
    Directory tmp = new Directory("tmp");
    Directory usr = new Directory("usr");

    // 컴파일러가 중요하게 생각하는건 타입 root는 Entery 타입이라 add 불가
    // 두가지 방법 존재
    // 1. 루트를 디렉토리로 타입캐스팅하기, .이 우선순위가 높으니 괄호로 한번 더 감싸기
    ((Directory) root).add(bin);
    // 할때마다 해야하니까 root를 디렉토리 타입으로 선언하기
    // bin 담기
    root.add(bin);
    root.add(tmp);
    root.add(usr);

    // bin에 파일 담기
    // v파일 생성자는 이름과 사이즈 필요함
    // bin.add(new FIle("vi", 100));
    // bin.add("latex",200);

    System.out.println(root.getSize());
    // 폴더는 사이즈 제로고 자식 파일크기만 다 더하니까

    // 아래 두 코드 동일함
    root.printList();
    root.printList("");
  }
}
