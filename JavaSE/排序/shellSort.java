/**
 * 希尔排序
 * 
 * 是基于直接插入排序的一个优化
 * 思路为进行多次直接插入排序 每次插入排序为间隔的插入排序(间隔长度取决于数组长度)
 * 最后一个间隔长度必须为1
 * 
 * 时间复杂度   平均为O(n^1.3) 最坏为O(n^2) 最好为O(n)
 * 空间复杂度   O(1)
 */
public class shell {
    public static void shellSort(int[] array){
        int len = array.length;
        while(len > 1){
            len /= 3+1;
            //间隔每次减少 最后一次为1
            insSort(array,len);
        }
    }
    //间隔的插入排序
    public static void insSort(int[] array,int n){
        for(int i = n;i < array.length;i++){
            int tmp = array[i];
            int j = i;
            for(;j - n >= 0&&tmp < array[j-n];j -= n){
                array[j] = array[j-n];
            }
            array[j] = tmp;
        }
    }
}