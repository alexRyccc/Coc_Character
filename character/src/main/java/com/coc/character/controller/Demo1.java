package com.coc.character.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ran_ych
 * @create 2020-01-27  19:57
 * @desc -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class Demo1 {
    byte[] bytes =new byte[1024*1024];

    public static void main(String[] args) {

        ArrayList<Demo1> list =new ArrayList<>();
        int count =0;
        while (true){
            list.add(new Demo1());
            count+=1;
        }
    }
}
