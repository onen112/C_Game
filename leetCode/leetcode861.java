
/**
 * 题目：https://leetcode-cn.com/problems/score-after-flipping-matrix/
 * 思路：
 *      采用贪心算法，首先要二进制数最大，第一个数字肯定是1
 *          所以通过for循环查找，如果第一个数字不是1，进行整行的反转
 *          然后如果第一列全是1 则后面每列的1要尽可能的多
 *          所以循环，如果该列的1的个数，小于0的个数，进行反转整列
 *          最后求出总和即可
 * 
 */
public class leetcode861 {
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }
    public static int matrixScore(int[][] A) {
        for(int i = 0;i < A.length;i++){
            if(A[i][0] == 0){

                A = tran(i,true,A);
            }
        }
        int count = 0;
        for(int i = 0;i < A[0].length;i++){
            for(int j = 0;j < A.length;j++){
                if(A[j][i] == 1){
                    count++;
                }
            }

            if(count <= (A.length/2)){
                A = tran(i,false,A);
            }
            count = 0;
        }
        int ret = 0;
        for(int i = 0;i < A.length;i++){
            String str = "";
            for(int j = 0;j < A[i].length;j++){
                str = str + A[i][j];
            }
            ret += Integer.valueOf(str,2);
        }


        return ret;
    }
    public static int[][] tran(int n,boolean b,int[][] A){
        if(b){
            for(int j = 0;j < A[n].length;j++){
                if(A[n][j] == 0){
                    A[n][j] = 1;
                }else{
                    A[n][j] = 0;
                }
            }

        }else{
            for(int i = 0;i < A.length;i++){
                if(A[i][n] == 0){
                    A[i][n] = 1;
                }else{
                    A[i][n] = 0;
                }
            }
        }
        return A;
    }
}