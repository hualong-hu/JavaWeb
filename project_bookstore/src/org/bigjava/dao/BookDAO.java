package org.bigjava.dao;
import	java.util.List;

import org.bigjava.pojo.Book;

/**
 * @ProjectName: JavaWeb
 * @ClassName: BookDAO
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-05 16:50
 * @Version v1.0
 */
public interface BookDAO {
    /**
     * 添加图书
     * @data: 2020-06-05-16:51
     * @User: 洛笙
     * @method: addBook
     * @params: [book]
     * @return: int
     * @Description: 描述
     */
    int addBook(Book book);

    /**
     * 通过id删除书本
     * @data: 2020-06-05-16:54
     * @User: 洛笙
     * @method: deleteBookById
     * @params: [id]
     * @return: int
     * @Description: 描述
     */
    int deleteBookById(Integer id);

    /**
     * 修改图书信息
     * @data: 2020-06-05-16:55
     * @User: 洛笙
     * @method: updateBook
     * @params: [book]
     * @return: int
     * @Description: 描述
     */
    int updateBook(Book book);
    /**
     * 通过id查询单个书本
     * @data: 2020-06-05-16:56
     * @User: 洛笙
     * @method: queryBookById
     * @params: [id]
     * @return: org.bigjava.pojo.Book
     * @Description: 描述
     */
    Book queryBookById(Integer id);

    /**
     * 查询全部书本
     * @data: 2020-06-05-16:57
     * @User: 洛笙
     * @method: queryBooks
     * @params: []
     * @return: java.util.List<org.bigjava.pojo.Book>
     * @Description: 描述
     */
    List<Book> queryBooks();
    /**
     * 查询页面的总个数
     * @data: 2020-06-07-15:07
     * @User: 洛笙
     * @method: queryForPageTotalCount
     * @params: []
     * @return: java.lang.Integer
     * @Description: 描述
     */
    Integer queryForPageTotalCount();
    /**
     * 分页查询数据
     * @data: 2020-06-07-15:12
     * @User: 洛笙
     * @method: queryForPageIteams
     * @params: [begin, pageSize]
     * @return: java.util.List<org.bigjava.pojo.Book>
     * @Description: 描述
     */
    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min,int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
