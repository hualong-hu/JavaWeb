package org.bigjava.bean;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Dom4jTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-20 1:07
 * @Version v1.0
 */
public class Dom4jTest {

    @Test
    public void test01() throws DocumentException {
        //创建一个saxReader输入流，用于读取xml配置文件，生成document对象
        SAXReader saxReader = new SAXReader();

        Document doc = saxReader.read("books.xml");

        System.out.println("doc = " + doc);

    }
    /**
     * @data: 2020-05-20-1:19
     * @User: 洛笙
     * @method: test02
     * @params: []
     * @return: void
     * @Description: 读取books.xml文件生成Book类
     */
    @Test
    public void test02() throws DocumentException {
        //1.读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");

        //2.通过document对象获取元素
        Element rootElement = document.getRootElement();

        //3.通过根元素获取book标签对象
        //element()和elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");

        //4.遍历，处理每个book标签转换为Book类
        for (Element book : books){
            //asXML() 把标签对象转换为标签字符串
            Element name = book.element("name");

            //getText() 可以获取标签中的文本内容
            String nameText = name.getText();

            //elementText() 直接获取指定标签名的文本内容
            String price = book.elementText("price");
            String author = book.elementText("author");

            //attributeValue() 获取元素属性的文本内容
            String sn = book.attributeValue("sn");
            String type = book.attributeValue("type");

            System.out.println(new Book(sn,type,nameText,Double.parseDouble(price),author));
        }
    }

}
