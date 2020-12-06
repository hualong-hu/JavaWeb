package org.bigjava.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ProjectName: JavaWeb
 * @ClassName: MyServletContextListener
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-30 21:27
 * @Version v1.0
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器被创建了！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器已销毁！");
    }
}
