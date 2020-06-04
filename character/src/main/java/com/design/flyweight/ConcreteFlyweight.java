package com.design.flyweight;

/**
 * @author ran_ych
 * @create 2020-05-26  16:49
 * @desc
 */
public class ConcreteFlyweight implements Flyweight {
    private Character intrinsicState = null;

    public ConcreteFlyweight(Character intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    /**
     * 外蕴状态作为参数传入方法中，改变方法的行为
     * 但是并不改变方法的内蕴状态
     */
    @Override
    public void operation(String state) {
        System.out.println("Intrinsic State = " + this.intrinsicState);
        System.out.println("Extrinsic State = " + state);
    }
}
