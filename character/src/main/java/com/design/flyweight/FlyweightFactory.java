package com.design.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ran_ych
 * @create 2020-05-26  16:50
 * @desc
 */
public class FlyweightFactory {
    private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();

    public synchronized Flyweight factory(Character state) {
        //查看对象是否存在

        Flyweight flyweight =files.get(state);
        if (flyweight==null){
            flyweight =new ConcreteFlyweight(state);
            files.put(state,flyweight);
        }
        return  flyweight;
    }

    /**
     * 复合享元工厂方法
     * @param compositeState
     * @return
     */
    public Flyweight factory(List<Character> compositeState) {
        ConcreteCompositeFlyweight concreteCompositeFlyweight = new ConcreteCompositeFlyweight();

        for (Character state : compositeState) {
            concreteCompositeFlyweight.add(state, this.factory(state));
        }

        return concreteCompositeFlyweight;
    }


}
