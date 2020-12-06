package org.bigjava.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ProjectName: JavaWeb
 * @ClassName: JdbcUtils
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-25 16:39
 * @Version v1.0
 */
public class JdbcUtils {
    private static ThreadLocal<Connection> connections = new ThreadLocal<Connection>();
    /**
     * @data: 2020-05-25-16:39
     * @User: 洛笙
     * @method: getConnection
     * @params: []
     * @return: java.sql.Connection
     * @Description: 获取数据库连接池中的连接
     */
    private static DataSource source;
    static {
        try {
            Properties properties = new Properties();
            InputStream stream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(stream);
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = connections.get();
        if (connection == null){
            //从数据库连接池中获取连接
            connection = source.getConnection();
            //保存到ThreadLocal对象中，供后面的jdbc操作使用
            connections.set(connection);
            //设置手动提交事务
            connection.setAutoCommit(false);
        }
        return connection;
    }
    /**
     * 提交事务，并关闭释放连接
     * @data: 2020-06-16-14:58
     * @method: commitAndClose
     * @params: []
     * @return: void
     */
    public static void commitAndClose(){
        Connection connection = connections.get();
        //如果不等于null，说明之前使用过连接，操作过数据库
        if (connection != null) {
            try {
                //提交事务
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    //关闭连接，释放资源
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则会出错，（因为Tomcat服务器底层使用了线程池技术）
        connections.remove();
    }
    /**
     * 回滚事务，并关闭释放连接
     * @data: 2020-06-16-15:03
     * @method: rollbackAndClose
     * @params: []
     * @return: void
     */
    public static void rollbackAndClose(){
        Connection connection = connections.get();
        //如果不等于null，说明之前使用过连接，操作过数据库
        if (connection != null) {
            try {
                //回滚事务
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    //关闭连接，释放资源
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则会出错，（因为Tomcat服务器底层使用了线程池技术）
        connections.remove();
    }
//    /**
//     * @data: 2020-05-25-16:40
//     * @User: 洛笙
//     * @method: close
//     * @params: []
//     * @return: void
//     * @Description: 关闭连接，放回数据库连接池
//     */
//    public static void close(Connection connection){
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
