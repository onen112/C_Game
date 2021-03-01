/**
 * 直接插入排序
 * 
 * 依次遍历数组 每次拿到一个元素向前找到它该在的位置并插入到那个位置
 * 
 * 时间复杂度   O(n^2) 最好为 O n （数组本身有序）
 * 空间复杂度   O(1)  
 */
public class insertSort {
    public static void InsertSort(int[] array){
        int i = 1;
        while(i < array.length){
            int j = i;
            int tmp = array[j];
            while(j > 0&&tmp < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = tmp;
            i++;
        }
    }
}