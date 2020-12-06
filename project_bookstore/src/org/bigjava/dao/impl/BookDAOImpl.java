package org.bigjava.dao.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.bigjava.dao.BaseDAO;
import org.bigjava.dao.BookDAO;
import org.bigjava.pojo.Book;

import java.util.List;

/**
 * @ProjectName: JavaWeb
 * @ClassName: BookDAOImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-05 17:00
 * @Version v1.0
 */
public class BookDAOImpl extends BaseDAO implements BookDAO {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`)values(?,?,?,?,?,?)";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql  = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` as imgPath from t_book where id = ?";
        return query(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` as imgPath from t_book";
        return queryList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number value = (Number) queryValue(sql);
        return value.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` as imgPath from t_book limit ?,?";

        return queryList(Book.class, sql, begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number value = (Number) queryValue(sql,min,max);
        return value.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` as imgPath " +
                "from t_book where price between ? and ? order by price limit ?,?";

        return queryList(Book.class, sql, min,max,begin,pageSize);
    }
}
