package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIteratorBackward implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIteratorBackward(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
//        책꽂이의 마지막 책 가리키게하기 : 책꽂이 길이 6
        this.index = bookShelf.getLength()-1;
    }

    @Override
    public boolean hasNext() {
//        index가 0또는 양수일경우
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index--;
        return book;
    }
}