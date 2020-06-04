package com.coc.character.controller;

import org.omg.IOP.Encoding;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ran_ych
 * @create 2020-05-06  11:01
 * @desc
 */
public class Test1 {


    public static void main(String[] args) throws IOException {
        int a =10;
        System.out.println(a<<1);
        System.out.println(a>>1>>1);
        System.out.println(a>>2);
        List list =new ArrayList(Arrays.asList(new String[]{"asd", "asd", "Asd", "DFG","asdasd"}));
        ByteArrayOutputStream st = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(st);
        out.writeObject(list);
        byte[] alBytes = st.toByteArray();
        System.out.println(alBytes.length);
        for (byte sta:alBytes ) {
            System.out.println( (char)((sta & 0xFF)<< 8)| (sta & 0xFF) );
        }
        ArrayList<String> all = null;
        try {
            all = (ArrayList<String>) new ObjectInputStream(
                    new ByteArrayInputStream(alBytes)).readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(String s : all) {
            System.out.println(s);
        }


}
}
