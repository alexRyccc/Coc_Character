package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ran_ych
 * @create 2019-10-23  11:30
 * @desc
 */
public class Reflect {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
       /* Class<?> clazz =Class.forName("Reflect.DemoBean");
        Constructor constructor =clazz.getConstructor(null);//拿到构造函数
        Field[] fields=clazz.getDeclaredFields();//拿到它定义的所有字段
        Method[]methods=clazz.getDeclaredMethods();//拿到他定义的所有方法
        //Constructor constructors = clazz.getConstructor(String.class,Integer.class,Double.class);//拿到有参构造函数

        for (Field field:fields){
             if (field.isAnnotationPresent(AnnotationDemo.class)){
                 System.out.println("有注解");
             }
            AnnotationDemo annotationDemo=field.getAnnotation(AnnotationDemo.class);
            if (annotationDemo!=null){
                System.out.println("注解 name："+annotationDemo.name());
                System.out.println("注解 value："+annotationDemo.value());
            }
            System.out.println("属性："+field.getName()+"   "+field.getModifiers());
        }*/


    Reflect r =new Reflect();
    int a =r.maxDistToClosest(new int[]{0,0,0,1,0,0,1});
        System.out.println(a);
    }

        public int maxDistToClosest(int[] seats) {
            int max =0;
            int set =0;
            for(int i=0;i<seats.length;i++){
                if(seats[i]==0){
                    set++;
                }else{
                    max =set;
                    System.out.println(set);
                    break;
                }
            }
            for(int i=0;i<seats.length;i++){
                if(seats[i]==0){
                    set++;
                }else{
                    max =Math.max(set/2+set%2,max);
                }
            }
            if(seats[seats.length-1]==0){
                max =Math.max(max,set);
            }
            return max;
        }



}
