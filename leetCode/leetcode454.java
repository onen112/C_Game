import java.util.*;
/**
 * 
 * 题目：
 *      https://leetcode-cn.com/problems/4sum-ii/
 */
public class leetcode454 {
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{},new int[]{},new int[]{},new int[] {}));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer,Integer> s = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < B.length;j++){
                l.add(C[i]+D[j]);
                s.put(A[i]+B[j],s.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for(int i : l){
            if(s.containsKey(-i)){
                count += s.get(-i);
            }
        }
        return count;
    }
}