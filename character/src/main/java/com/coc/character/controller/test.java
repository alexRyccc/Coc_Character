package com.coc.character.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class test {
    public static void main(String[] args) {
        test t =new test();
        int [] i =new int[]{0,0,1,1,1};
        System.out.println(t.numRabbits(i));
    }

        public int numRabbits(int[] answers) {
            Map<Integer,Integer> map =new HashMap<>();
            int set =0;
            for(int i:answers){
                map.put(i,map.getOrDefault(i,0)+1);
            }
            for(Integer i:map.keySet()){

                if(i==0){
                    set+=map.get(i);
                }
                else if (map.get(i)<=i+1){
                    set+=map.get(i);
                }else{
                    int c =map.get(i)/i;
                    set += i*c;
                }
                System.out.println(i+"="+map.get(i)+"---"+set);
            }
            return set;
        }

    public String reverseOnlyLetters(String S) {

        char[] chars =S.toCharArray();
        int i=0,j=S.length()-1;
        while(i<j){
            char c = S.charAt(i);
            if(isLetter(c)){
                if(j>=i&&isLetter(S.charAt(j))){
                    char t =S.charAt(j);
                    chars[i]=t;
                    chars[j]=c;
                    i++;
                    j--;
                }else{
                    j--;
                }

            }else{
                i++;
            }
        }

        return new String(chars);
    }
    public boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}