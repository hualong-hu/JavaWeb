package org.bigjava.service.impl;

import org.bigjava.dao.BookDAO;
import org.bigjava.dao.impl.BookDAOImpl;
import org.bigjava.pojo.Book;
import org.bigjava.pojo.Page;
import org.bigjava.service.BookService;

import java.util.List;

/**
 * @ProjectName: JavaWeb
 * @ClassName: BookServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-05 17:45
 * @Version v1.0
 */
public class BookServiceImpl implements BookService {
    BookDAO bookDAO = new BookDAOImpl();
    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        //2.设置每页显示的数量
        page.setPageSize(pageSize);
        //3.求总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCount();
        //4.设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //1.设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDAO.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize,int min,int max) {
        Page<Book> page = new Page<>();

        //2.设置每页显示的数量
        page.setPageSize(pageSize);
        //3.求总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCountByPrice(min,max);
        //4.设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //1.设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDAO.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

}
