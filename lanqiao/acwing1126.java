/**
 * 题目：https://www.acwing.com/problem/content/1228/
 * 
 * 包子凑数
 * 
 * 思路：
 *      1. 由数学公式得若所有得数字不互质 那么就有无穷得数凑不出来
 *      2. 若两个数互质 且得最大公约数为1 两个数不能凑成最大得数为  a*b-a-b -> https://www.acwing.com/problem/content/1207/
 * 
 * 
 *      由上面加dp数组即可解出答案
 * 
 */
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] nums = new int[n];
        int tmp = s.nextInt();
        nums[0] = tmp;
        int num = 0;
        for(int i = 1;i < n;i++){
            num = s.nextInt();
            tmp = maxCommonDivisor(tmp,num);
            nums[i] = num;
        }
        if(tmp != 1){
            System.out.println("INF");
        }else{
            int[] dp = new int[100010];
            for(int i = 0;i < nums.length;i++){
                dp[nums[i]] = 1;
                for(int j = 0;j < dp.length;j++){
                    if(dp[j] == 1 && j+nums[i] < dp.length){
                        dp[j+nums[i]]=1;
                    }
                }
            }
            int count = 0;
            for(int i = 1;i < dp.length;i++){
                if(dp[i] == 0) count++;
            }
            System.out.println(count);
          
        }
    }
        
    public static int maxCommonDivisor(int x,int y){
        while(x!=y){
            if(x>y){
                x=x-y;
            }else{
                y=y-x;
            }
        }
        return x;
    }
}