package link;

/**
 * @author ran_ych
 * @create 2019-10-22  10:32
 * @desc
 */
public class Link {
    public int age;
    public String name;
    public Link next;  //指向该链结点的下一个链结点
    public Link(int age,String name){
        this.age = age;
        this.name = name;
    }

    //打印该链结点的信息
    public void displayLink(){
        System.out.println("name:"+name+",age:"+age);
    }


}
