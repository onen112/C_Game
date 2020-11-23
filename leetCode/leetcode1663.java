public class leetcode1663{
    /**
     * 题目：
     *      https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value/
     * 
     * 思路：
     *      字符的数目肯定是给定的n所以，最少会有一个n个 ‘a’ 的数组
     *      所以先创建一个全是 ‘a’ 长度为n的数组，要求字符串最小，所以从最后一个开始增加
     *      1. 可以每次增加 1 直到增加达到k结束（当增加到 ‘z’ 是从下一个开始增加）
     *          不过这样需要累加很多次，会超出时间限制
     *      2. 优化办法：
     *          从最后一个开始，如果距离目标 k 还差的值大于25时，直接把该字符 + 25，进行下一个
     *          若距离k小于25则每次加一次，最后返回该数组组成的字符串 
     */
    public static void main(String[] args) {
        System.out.println(getSmallestString(3,20));
    }
    public static String getSmallestString(int n, int k) {
        char[] a = new char[n];
        int count = k - n;
        for(int i = 0;i < n;i++){
            a[i] = 'a';
        }
        int j = n - 1;
        while(count > 0){
            if(count > 25){
                a[j] = (char)((int)a[j] + 25);
                count -= 25;
            }else{
                a[j] = (char)((int)a[j] + count);
                count = 0;
                break;
            }
            if(j > 0){
                j--;
            }else{
                break;
            }
        }
       
        return  String.valueOf(a);
    }

}