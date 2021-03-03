/**
 * 快速排序
 * 
 * 时间复杂度：O(n*logN)(平均)  n^2（最差 数组本身有序）
 * 空间复杂度：O(logN)（平均）  O(n)（最差）
 *      
 * 思路：
 *      先定义一个标准(p = arr[left]) 从后向前找小于 p 的数字放到left位置
 *      然后从左向右找大于 p 的数字 放到 right 位置
 *      然后在从后向前找......
 *      直到left >= right 结束本次循环 将 arr[left] = p
 *      这样一趟下来数组 中元素p 左边的值都小于 p 右边的值都大于p
 * 
 *      然后递归对p左边 和 p 右边进行排序即可 
 */

public class quick {
    public static void quickSort(int[] arr){
        quickSortInternal(arr,0,arr.length-1);
    }
    public static void quickSortInternal(int[] arr,int left,int right){
        //递归的结束条件
        if(left >= right) return;
        int l = left;
        int r = right;
        //定义一个标准 p
        int p = arr[left];
        while(l < r){
            //从后向前找小于p的
            while(l < r && arr[r] > p){
                r--;
            }
            if(l < r){
                arr[l] = arr[r];
                l++;
            }

            //从前向后找大于p的
            while(l < r && arr[l] < p){
                l++;
            }
            if(l < r){
                arr[r] = arr[l];
                r--;
            }
        }
        //把p放置到应该在的位置
        arr[l] = p;

        //对p左右进行递归
        quickSortInternal(arr,left,l-1);
        quickSortInternal(arr,l+1,right);
    }
}