package org.bigjava.test;

import org.bigjava.dao.impl.BookDAOImpl;
import org.bigjava.pojo.Book;
import org.bigjava.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @ProjectName: JavaWeb
 * @ClassName: BookDAOImplTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-05 17:21
 * @Version v1.0
 */
public class BookDAOImplTest {
    BookDAOImpl bookDAO = new BookDAOImpl();
    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null,"龙哥为什么这么帅！","龙哥",new BigDecimal(999.99),200000,0,null
        ));
    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void updateBook() {
        bookDAO.updateBook(new Book(21,"三国演义","罗贯中",new BigDecimal(99.99),200,59,null
        ));
    }

    @Test
    public void queryBookById() {
        Book book = bookDAO.queryBookById(21);
        System.out.println("book = " + book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDAO.queryBooks();
        for (Book book : books){
            System.out.println(book);
        }

    }
    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDAO.queryForPageTotalCount());
    }
    @Test
    public void queryForPageItems(){
        for (Book item : bookDAO.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(item);
        }
    }
    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDAO.queryForPageTotalCountByPrice(10, 50));
    }
    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDAO.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 10, 50)) {

            System.out.println(book);
        }
    }

}