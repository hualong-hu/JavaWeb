package org.bigjava.json;
import	java.util.Map;
import	java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bigjava.bean.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: JavaWeb
 * @ClassName: JsonTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-17 11:20
 * @Version v1.0
 */
public class JsonTest {
    /**
     * Javabean与json的互转
     * @data: 2020-06-17-11:25
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void test() {
        Person person = new Person(1, "龙哥");
        //创建json对象实例
        Gson gson = new Gson();
        //toJson()：将Javabean对象转换成json字符串
        String personJson = gson.toJson(person);
        System.out.println("personJson = " + personJson);
        //fromJson():将json字符串转换成java对象，第一个参数是json字符串，第二个参数是转换回去的java对象类型
        Person person1 = gson.fromJson(personJson, Person.class);
        System.out.println("person1 = " + person1);

    }
    /**
     * json与List集合的互转
     * @data: 2020-06-17-11:26
     * @method: test1
     * @params: []
     * @return: void
     */
    @Test
    public void test1() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(1, "国哥"));
        list.add(new Person(2, "康师傅"));

        Gson gson = new Gson();

        //把list转换成json字符串
        String toJson = gson.toJson(list);
        System.out.println("toJson = " + toJson);

        //把json字符串转换成list
        List<Person> json = gson.fromJson(toJson, new TypeToken<List<Person>>(){}.getType());
        System.out.println("json = " + json);
        Person person = json.get(0);
        System.out.println("person = " + person);

    }
    /**
     * json与Map集合的互转
     * @data: 2020-06-17-21:55
     * @method: test2
     * @params: []
     * @return: void
     */
    @Test
    public void test2(){

        HashMap<Integer, Person> hashMap = new HashMap<>();
        hashMap.put(1,new Person(1,"国哥"));
        hashMap.put(2,new Person(2,"康师傅"));

        Gson gson = new Gson();
        //将map集合转换成json字符串
        String mapJson = gson.toJson(hashMap);
        System.out.println("mapJson = " + mapJson);

        //将json字符串转换成map集合
        Map<Integer, Person> fromJson = gson.fromJson(mapJson, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println("fromJson = " + fromJson);

        Person person = fromJson.get(1);
        System.out.println("person = " + person);

    }
}
