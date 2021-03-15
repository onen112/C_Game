/**
 * 题目：https://leetcode-cn.com/problems/spiral-matrix/
 * 
 * 螺旋矩阵
 * 
 * 思路： 按照要求收缩边界条件并赋值即可
 */
public class leetcode54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        int down = 0,left = 0,right = 1,up = 0;
        int d = matrix.length;
        int l = 0;
        int r = matrix[0].length;
        int u = 0;
        while(ret.size() < (matrix.length) * (matrix[0].length)){
            if(right == 1){
                if(j < r){
                    ret.add(matrix[i][j]);
                    j++;
                }else{
                    right = 0;
                    down = 1;
                    r--;
                    j--;
                    i++;
                }
            }
            if(down == 1){
                if(i < d){
                ret.add(matrix[i][j]);
                    i++;
                }else{
                    down = 0;
                    left = 1;
                    d--;
                    i--;
                    j--;
                }
            }
            if(left == 1){
                if(j >= l){
                    ret.add(matrix[i][j]);
                    j--;
                }else{
                    up = 1;
                    left = 0;
                    l++;
                    j++;
                    i--;
                }
            }
            if(up == 1){
                if(i > u){
                    ret.add(matrix[i][j]);
                    i--;
                }else{
                    up = 0;
                    right = 1;
                    u++;
                    i++;
                    j++;
                }
            }

        }
        return ret;
    }
}
