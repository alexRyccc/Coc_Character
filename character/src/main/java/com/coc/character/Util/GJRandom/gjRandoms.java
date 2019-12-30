package com.coc.character.Util.GJRandom;

/**
 * @author ran_ych
 * @create 2019-12-25  21:05
 * @desc
 */
public class gjRandoms {

    public   int doRamdon() {
        double[] ds = new double[] { 1.0,4.0,10.0,25.0,30.0,15.0,10.0,5.0,0.1 };
        double sum = getSum(ds);
        double last = 0;
        for (int i = 0; i < ds.length; i++) {
            sum = sum- last;
            double random = Math.random();
            if (random <= ds[i] / sum) {
                return i;
            }
            last = ds[i];
        }

        return 8;
    }

    private  double getSum(double[] weight) {
        double sum = 0;
        for (double d : weight) {
            sum += d;
        }
        return sum;
    }
}
