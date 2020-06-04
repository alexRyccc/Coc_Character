package com.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ran_ych
 * @create 2020-05-26  17:15
 * @desc
 */
public class ConcreteCompositeFlyweight implements Flyweight  {
    private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();

    /**
     * 添加一个新的单纯享元对象到聚集中
     * @param key
     * @param flyweight
     */
    public void add(Character key, Flyweight flyweight) {
        files.put(key, flyweight);
    }

    /**
     * 外蕴状态作为参数传递到方法中
     */
    @Override
    public void operation(String state) {
        Flyweight flyweight = null;
        for (Object o: files.keySet()) {
            flyweight = files.get(o);
            flyweight.operation(state);
            System.out.println(flyweight);
        }
    }
}
