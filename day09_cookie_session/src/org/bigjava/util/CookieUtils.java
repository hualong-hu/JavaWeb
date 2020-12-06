package org.bigjava.util;

import javax.servlet.http.Cookie;

/**
 * @ProjectName: JavaWeb
 * @ClassName: CookieUtils
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-09 23:34
 * @Version v1.0
 */
public class CookieUtils {
    /**
     * 查找指定名称的Cookie对象
     * @data: 2020-06-09-23:37
     * @User: 洛笙
     * @method: findCookie
     * @params: [name, cookies]
     * @return: javax.servlet.http.Cookie
     * @Description: 描述
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (name == null || cookies == null || cookies.length == 0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }


}
