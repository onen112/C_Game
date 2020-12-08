package com.onen.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 题目
 *      https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 * 思路
 *      采用回溯算法进行解题，参考
 *      https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/javahui-su-suan-fa-tu-wen-xiang-jie-ji-b-vg5z/
 *      的题解，详情见注释
 *
 */

public class leetcode842 {
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("0123"));
    }
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ret = new ArrayList<>();
        backtrack(S.toCharArray(),ret,0);
        return ret;
    }
    /**
     *回溯算法：
     *      基本框架：
     *      private void backtrack("原始参数") {
     *     //终止条件(递归必须要有终止条件)
     *     if ("终止条件") {
     *         //一些逻辑操作（可有可无，视情况而定）
     *         return;
     *     }
     *
     *     for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
     *         //一些逻辑操作（可有可无，视情况而定）
     *
     *         //做出选择
     *
     *         //递归
     *         backtrack("新的参数");
     *         //一些逻辑操作（可有可无，视情况而定）
     *
     *         //撤销选择
     *     }
     * }
     *
     */

    public static boolean backtrack(char[] arrays,List<Integer> ret,int n){
        //n走到最后（分割完成），并且ret的内容大于3说明ret里面放的是斐波那契数列
        if(n == arrays.length && ret.size() >= 3){
            return true;
        }
        //如果分割未完成，或者完成了ret的长小于3
        for(int i = n;i < arrays.length;i++){
            //除0以外所以数字不能以0开头
            if(arrays[n] == '0' && i > n){
                break;
            }
            //分割字符串 n - i+1 位置，并转化为long类型（用于判断是否超出 Integer.MAX_VALUE ）
            long num = toLong(arrays,n,i+1);
            //该数字大于 Integer.MAX_VALUE 不符合题目要求（继续分割只会更大，所以直接结束）
            if(num > Integer.MAX_VALUE){
                break;
            }
            //num符合要求
            int size = ret.size();
            //判断是否符合前两个数之和等于num，大于直接结束（继续分割只会更大），小于不用处理，让其继续分割
            if(size >= 2&&num > ret.get(size-2) + ret.get(size-1)){
                break;
            }
            //满足要求，将该数字添加到ret集合中
            if(size <= 1||num == ret.get(size-2) + ret.get(size-1)){
                ret.add((int)num);
                if(backtrack(arrays,ret,i+1)){
                    return true;
                }
                //不满足条件，删掉最后一个值继续回溯
                ret.remove(ret.size() - 1);
            }
        }
        return false;
    }
    //转化为long类型
    public static long toLong(char[] arr,int b,int e){
        long l = 0L;
        long weight = 1L;
        for(int i = e-1;i >= b;i--){
            l += (arr[i]-'0')*weight;
            weight *= 10;
        }
        return l;
    }
}