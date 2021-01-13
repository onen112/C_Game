package com.onen.leetcode;

/**
 * 题目：https://leetcode-cn.com/problems/redundant-connection/submissions/
 *      删除图的一个边，使其不包含环
 *      思路：并查集找到能构成环的边进行返回即可
 */
public class leetcode684 {
    public static void main(String[] args) {
        int[] a = findRedundantConnection(new int[][]{{1, 4}, {3, 4},{1,3},{1,2},{4,5}});
        System.out.println(a[0] + "  " + a[1]);
    }
    public static int[] findRedundantConnection(int[][] edges) {
        //用来保存每个节点的父节点
        int[] parent = new int[edges.length+1];
        for(int i = 0;i < edges.length;i++){
            if(!union_(edges[i][0],edges[i][1],parent))
                return edges[i];
        }
        return null;
    }
    //查找父节点，如果没有，就是自己
    public static int find_root(int x,int[] parent){
        while(parent[x] != 0){
            x = parent[x];
        }
        return x;
    }
    //进行合并，或判断是否构成环
    public static boolean union_(int x,int y,int[] parent){
        int x_root = find_root(x,parent);
        int y_root = find_root(y,parent);
        //要添加的边的两个点的父节点相等，则说明会构成环
        if(x_root == y_root){
            System.out.println(x_root + " " + y_root);
            return false;
        }else{
            //否则，将节点合并（其实可以通过树的深度，来决定将谁添加到谁后面这里没写）
            parent[y_root] = x_root;
        }
        return true;
    }
}