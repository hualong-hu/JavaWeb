package org.bigjava.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.bigjava.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ProjectName: JavaWeb
 * @ClassName: BaseDAO
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-25 21:16
 * @Version v1.0
 */
public abstract class BaseDAO {
    /**
     * @data: 2020-05-25-22:01
     * @User: 洛笙
     * @method: update
     * @params: [sql, args]
     * @return: int
     * @Description: 用于增删改操作
     */
    public int update(String sql,Object...args){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JdbcUtils.getConnection();
            return runner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * @data: 2020-05-25-22:09
     * @User: 洛笙
     * @method: query
     * @params: [clazz, sql, args]
     * @return: T
     * @Description: 查询返回表中的一条记录
     */
    public <T> T query( Class<T> clazz,String sql,Object...args){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JdbcUtils.getConnection();
            BeanHandler<T> handler = new BeanHandler<>(clazz);
            return runner.query(connection,sql, handler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * @data: 2020-05-25-22:13
     * @User: 洛笙
     * @method: queryList
     * @params: [clazz, sql, args]
     * @return: java.util.List<T>
     * @Description: 用于返回表中的多条记录
     */
    public<T> List<T> queryList(Class<T> clazz, String sql, Object...args){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JdbcUtils.getConnection();
            BeanListHandler<T> handler = new BeanListHandler<>(clazz);
            return runner.query(connection,sql, handler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * @data: 2020-05-25-22:19
     * @User: 洛笙
     * @method: queryValue
     * @params: [sql, args]
     * @return: java.lang.Object
     * @Description: 用于返回表中查询的特殊值
     */
    public Object queryValue(String sql,Object...args){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JdbcUtils.getConnection();
            ScalarHandler handler = new ScalarHandler();
            return runner.query(connection,sql, handler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
