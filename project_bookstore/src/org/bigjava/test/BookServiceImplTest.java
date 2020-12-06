package org.bigjava.test;

import org.bigjava.pojo.Book;
import org.bigjava.service.BookService;
import org.bigjava.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: JavaWeb
 * @ClassName: BookServiceImplTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-05 17:50
 * @Version v1.0
 */
public class BookServiceImplTest {
   BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "龙哥是真滴厉害!", "龙哥", new BigDecimal(999.99), 500, 10, null
        ));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBookBy() {
        bookService.updateBook(new Book(22, "逆天邪神", "火星引力", new BigDecimal(999.99), 500, 10, null
        ));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,4,10,50));
    }

}