package org.bigjava.bean;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Person
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-17 11:18
 * @Version v1.0
 */
public class Person {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
