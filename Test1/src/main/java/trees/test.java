package trees;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author ran_ych
 * @create 2019-10-22  16:49
 * @desc
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class c = Class.forName("trees.Node");
        Node node = new Node();
        Method[] methods = c.getDeclaredMethods();
       /* for (Method m : methods) {
             System.out.println("方法："+m);
        }
        System.out.println("-------------获得类的所有声明的属性---------------");*/
        Field[] fields = c.getDeclaredFields();
       /* for (Field field : fields) {
            System.out.println(field);
        }*/
        String name = "name|age|leftChild|rightChild";
        String[] names = name.split("\\|");
        for (int i = 0; i < fields.length; i++) {

            Field name1 = node.getClass().getDeclaredField(names[i]);
            if(name1.getName().equals(names[i])){
                name1.setAccessible(true);
                name1.set(node,"树");
            }
            break;

        }
        System.out.println("前：" + node.name);
        System.out.println(node.name);

    }
}
