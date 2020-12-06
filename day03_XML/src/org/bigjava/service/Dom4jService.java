package org.bigjava.service;

import org.bigjava.bean.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.*;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Dom4jService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-27 9:38
 * @Version v1.0
 */
public class Dom4jService {

    public List getBook(){
        //1.读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            File file = new File("C:\\Users\\洛笙\\IdeaProjects\\JavaWeb\\day03_XML\\src\\books.xml");
            document = saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //2.通过document对象获取元素
        Element rootElement = document.getRootElement();

        //3.通过根元素获取book标签对象
        //element()和elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        ArrayList<Object> list = new ArrayList<>();
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
            Book book1 = new Book(sn, type, nameText, Double.parseDouble(price), author);
            list.add(book1);
//            System.out.println(book1);
        }
        return list;
    }


    @Test
    public void test(){
       List list = getBook();
        System.out.println(list.get(1));

    }
}
