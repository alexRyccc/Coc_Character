package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ran_ych
 * @create 2019-10-24  16:41
 * @desc
 */
public class Leetcode216 {
    public  static void main(String[] args) {
        Leetcode216 l =new Leetcode216();
        System.out.println(l.combinationSum3(3,7));
    }
    List<List<Integer>>res =new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(1,k,n,new ArrayList<Integer>());
        return res;
    }
    public void backTrack(int start,int k,int n,ArrayList<Integer>list){
        if (k==0){
            if (n==0){
                res.add(new ArrayList<>(list));
            }else{
                return;
            }
        }
        for (int i=start;i<=9;i++){
            if (i>n){
                return;
            }else{
                list.add(i);
                backTrack(i+1,k-1,n-i,list);
                list.remove(list.size()-1);

            }
        }
    }

}
