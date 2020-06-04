package com.coc.createuser;

import java.util.Arrays;
import java.util.HashSet;




/**
 * @author ran_ych
 * @create 2020-04-22  19:36
 * @desc
 */
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

public class Main {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String n =in.next();
        String n="AVA";
        char[]c =n.toCharArray();
        HashSet<String> set =new HashSet<String>();
        changeNum(c,0,set);
        System.out.println(set.size());
    }
    private static void changeNum(char[] n,int start,HashSet<String>set){
       if(n==null||n.length==0) {
           System.out.println(0);
       }
       if(start==n.length-1){
           set.add(Arrays.toString(n));
       }else{
           for(int i=start;i<n.length;i++){
               swap(n,i,start);
               changeNum(n,start+1,set);
               swap(n,i,start);
           }
       }
    }
    private static  void swap(char[]c ,int s,int e){
        char t =c[s];
        c[s]=c[e];
        c[e]=t;
    }
}
