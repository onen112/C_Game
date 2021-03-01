/**
 * 先将待排序数组创建为堆  排升序要建大堆  排降序要建小堆
 * 
 * 时间复杂度  O(n*log(n))
 * 空间复杂度  O(1)
 */
public class heapSort {
    public static void HeapSort(int[] arr){
        Heap.createHeap(arr);
        //每次将堆顶元素和数组最后（无序的最后一个元素）一个元素交换然后向下调整到剩余这个位置
        for(int i = arr.length-1;i >= 0;i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            Heap.shiftDown(arr,i,0);
        }
    }
}