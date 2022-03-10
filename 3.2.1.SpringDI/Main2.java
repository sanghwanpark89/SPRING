package com.fastcampus.ch3.diCopy2;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Truck extends Car{}
class Engine{}
class Door{}

class AppContext{
    Map map; // Instance Storage

    AppContext(){
        try {
            Properties p = new Properties();
            p.load(new FileReader("config.txt"));

            //  Store the information from the properties into the map
            map = new HashMap(p);

            //  반복문으로 클래스 이름을 얻어서 객체를 생성하고 다시 map에 저장
            //  Get the class name from for loop then create the instance then store the information into map
            for(Object key : map.keySet()){
                Class clazz = Class.forName((String)map.get(key));
                map.put(key, clazz.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("car", new SportsCar());
        map.put("engine", new Engine());
        map.put("door", new Door());
    }

    Object getBean(String key){
        return map.get(key);
    }
}

public class Main2 {
    public static void main(String[] args) throws Exception{
        AppContext ac = new AppContext();
        Car car = (Car)ac.getBean("car");
        Engine engine = (Engine) ac.getBean("engine");
        Door door = (Door) ac.getBean("door");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("door = " + door);
    }
}

/* Result
car = com.fastcampus.ch3.diCopy2.SportsCar@2d554825
engine = com.fastcampus.ch3.diCopy2.Engine@68837a77
door = com.fastcampus.ch3.diCopy2.Door@6be46e8f
*/
