package org.bigjava.utils;
import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;


/**
 * @ProjectName: JavaWeb
 * @ClassName: WebUtils
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-04 23:35
 * @Version v1.0
 */
public class WebUtils {
    /**
     * 把Map中的值注入到对应的Javabean中
     * @data: 2020-06-04-23:51
     * @User: 洛笙
     * @method: copyParamToBean
     * @params: [req, bean]
     * @return: T
     * @Description: 描述
     */
    public static <T> T copyParamToBean(Map map , T bean) {
        try {
            System.out.println("注入之前：" + bean);
            //把所有请求的参数都注入到user对象中！
            BeanUtils.populate(bean, map);
            System.out.println("注入之后："+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    /**
     * 将字符串转换成为int类型的数据
     * @data: 2020-06-06-20:49
     * @User: 洛笙
     * @method: parseInt
     * @params: [string, defaultValue]
     * @return: int
     * @Description: 描述
     */
    public static int parseInt(String string , int defaultValue){
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
