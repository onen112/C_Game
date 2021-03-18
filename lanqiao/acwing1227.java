/**
 * 题目：https://www.acwing.com/problem/content/1229/
 * 
 * 分巧克力
 * 
 * 思路：
 *      穷举+二分
 *      每次分的最大块数为所有巧克力的最长边
 *      然后每次块数从最长边的一半开始试分
 *      如果可以分够向右二分  否则向左二分
 *      最终返回 m 的值即可
 */
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int w = 0;
        int h = 0;
        int max = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            w = s.nextInt();
            h = s.nextInt();
            max = Math.max(w,max);
            max = Math.max(h,max);
            list.add(new int[]{w,h});
        }
        int l = 0;
        int r = max;
        int m = (r+l)/2;
        int count = 0;
        while(l <= r){
            count = 0;
            for(int[] i : list){
                count += (i[0]/m) * (i[1]/m);
            }
            if(count > k){
                l = m+1;
            }else if(count < k){
                r = m-1;
            }else{
                break;
            }
            m = (l+r)/2;
        }

        System.out.println(m);
    }
}