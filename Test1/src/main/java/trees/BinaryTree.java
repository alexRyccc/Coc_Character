package trees;

/**
 * @author ran_ych
 * @create 2019-10-22  11:12
 * @desc
 */
public class BinaryTree {
    private Node root;

    public static final int PREORDER = 1;   //前序遍历
    public static final int INORDER = 2;    //中序遍历
    public static final int POSTORDER = 3;  //后序遍历


    public BinaryTree(Node root) {
        this.root = root;
    }
    /**
     * 关键词查询
     */
    public Node find(int key){
        Node cur =root;
        if (cur ==null){
            return null;
        }
       /* while (cur.age!=key){
            if (key<cur.age){
                cur =cur.leftChild;
            }else {
                cur =cur.rightChild;
            }
            if (cur ==null){
                return null;
            }
        }*/
        return cur;
    }
    //遍历
    public void traverse(int type){
        switch(type){
            case 1:
                System.out.print("前序遍历：\t");
                preorder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("中序遍历：\t");
                inorder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("后序遍历：\t");
                postorder(root);
                System.out.println();
                break;
        }

    }
    //前序
    public void preorder(Node currentRoot){
        if (currentRoot!=null){
            System.out.print(currentRoot.age+"\t");
            preorder(currentRoot.leftChild);
            preorder(currentRoot.rightChild);
        }
    }
    //中序
    public void inorder(Node currentRoot){
        if (currentRoot!=null){
            inorder(currentRoot.leftChild);  //先对当前节点的左子树对进行中序遍历
            System.out.print(currentRoot.age+"\t"); //然后访问当前节点
            inorder(currentRoot.rightChild);  //最后对当前节点的右子树对进行中序遍历
        }
    }
    //后序
    public void postorder(Node currentRoot){
        if(currentRoot != null){
            postorder(currentRoot.leftChild);
            postorder(currentRoot.rightChild);
            System.out.print(currentRoot.age+"\t");
        }
    }

}
