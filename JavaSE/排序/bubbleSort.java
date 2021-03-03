/**
 * 冒泡排序
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */

class bubble {
    public static void bubbleSort(int[] arr){
        int tmp;
        for(int i = 0;i < arr.length-1;i++){
            for(int j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}