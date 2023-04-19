import java.util.Iterator;
import javax.swing.text.html.StyleSheet;

public class Main {

  public static void main(String[] args) {
    BookShelf bookShelf = new BookShelf(4);
    bookShelf.appendBook(new Book("BookA"));
    bookShelf.appendBook(new Book("BookB"));
    bookShelf.appendBook(new Book("BookC"));
    bookShelf.appendBook(new Book("BookD"));

    // 명시적 Iterator 선언
    Iterator<Book> it = bookShelf.iterator();
    //
    while (it.hasNext()) {
      Book book = it.next();
      System.out.println(book.getName());
    }

    //확장된 for 문 쓰기
    for (Book book : bookShelf) {
      System.out.println(book.getName());
    }
  }
}
