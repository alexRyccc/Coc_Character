package com.design.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ran_ych
 * @create 2020-05-26  17:11
 * @desc
 */
public class Client {
    public static void main(String[] args) {
        List<Character> compositeState = new ArrayList<Character>();

        compositeState.add('A');
        compositeState.add('B');
        compositeState.add('C');
        compositeState.add('B');
        compositeState.add('A');

        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight compositeFly1 = flyweightFactory.factory(compositeState);
        Flyweight compositeFly2 = flyweightFactory.factory(compositeState);

        compositeFly1.operation("Composite1 Call");
        compositeFly2.operation("Composite2 Call");

        System.out.println("---------------------------------------------");
        System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));
        System.out.println(compositeFly1);
        System.out.println(compositeFly2);

        Character charState = 'A';
        Flyweight flyweight1 = flyweightFactory.factory(charState);
        Flyweight flyweight2 = flyweightFactory.factory(charState);
        System.out.println("单纯享元模式是否可以共享对象：" + (flyweight1 == flyweight2));
    }
}
