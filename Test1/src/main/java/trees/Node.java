package trees;




/**
 * @author ran_ych
 * @create 2019-10-22  11:09
 * @desc
 */
public class Node {
    String age;
    String name;
    Node leftChild;  //左子节点的引用
    Node rightChild; //右子节点的引用

    public Node(){
        this.age = age;
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    //打印该节点的信息
    public void displayNode(){
        System.out.println("name:"+name+",age:"+age);
    }

}
