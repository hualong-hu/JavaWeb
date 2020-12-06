package org.bigjava.service;
import	java.util.List;

import org.bigjava.pojo.Book;
import org.bigjava.pojo.Page;

/**
 * @ProjectName: JavaWeb
 * @ClassName: BookService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-05 17:40
 * @Version v1.0
 */
public interface BookService {
    /**
     * 添加图书
     * @data: 2020-06-05-17:41
     * @User: 洛笙
     * @method: addBook
     * @params: [book]
     * @return: void
     * @Description: 描述
     */
    void addBook(Book book);
    /**
     * 通过id删除书本
     * @data: 2020-06-05-17:44
     * @User: 洛笙
     * @method: deleteBookById
     * @params: [id]
     * @return: void
     * @Description: 描述
     */
    void deleteBookById(Integer id);
    /**
     * 修改书本信息
     * @data: 2020-06-05-17:44
     * @User: 洛笙
     * @method: updateBookBy
     * @params: [book]
     * @return: void
     * @Description: 描述
     */
    void updateBook(Book book );
    /**
     * 通过id查询单个书本
     * @data: 2020-06-05-17:44
     * @User: 洛笙
     * @method: queryBookById
     * @params: [id]
     * @return: org.bigjava.pojo.Book
     * @Description: 描述
     */
    Book queryBookById(Integer id);
    /**
     * 查询所有的书本
     * @data: 2020-06-05-17:45
     * @User: 洛笙
     * @method: queryBooks
     * @params: []
     * @return: java.util.List<org.bigjava.pojo.Book>
     * @Description: 描述
     */
    List<Book> queryBooks();

    /**
     * 分页查询
     * @data: 2020-06-07-14:44
     * @User: 洛笙
     * @method: page
     * @params: [pageNo, pageSize]
     * @return: org.bigjava.pojo.Page<org.bigjava.pojo.Book>
     * @Description: 描述
     */
    Page<Book> page(int pageNo, int pageSize);
    /**
     * 通过价格进行分页查询
     * @data: 2020-06-08-14:33
     * @User: 洛笙
     * @method: pageByPrice
     * @params: [pageNo, pageSize, min, max]
     * @return: org.bigjava.pojo.Page<org.bigjava.pojo.Book>
     * @Description: 描述
     */
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);

}
