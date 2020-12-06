package org.bigjava.bean;


/**
 * @ProjectName: JavaWeb
 * @ClassName: Book
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-20 1:01
 * @Version v1.0
 */
public class Book {

    private String sn;
    private String name;
    private double price;
    private String author;
    private String type;

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(String sn,  String type,String name, double price, String author) {
        this.sn = sn;
        this.type = type;
        this.name = name;
        this.price = price;
        this.author = author;
    }
}
