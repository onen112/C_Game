public class Heap {
    /**
     *递归创建小堆
     * @param arr
     * @param size
     * @param index
     *
     * public static void shiftDown(int[] arr,int size,int index){
     *         int child;
     *         if(index*2 + 1 >= size){
     *             return;
     *         }else if(index*2 + 2 >= size ){
     *             child = index*2+1;
     *         }else{
     *             child = arr[index*2+1] < arr[index*2+2]?index*2+1:index*2+2;
     *         }
     *         if(arr[child] < arr[index]){
     *             int tmp = arr[child];
     *             arr[child] = arr[index];
     *             arr[index] = tmp;
     *             shiftDown(arr,size,child);
     *         }
     *     }
     */
    
    //向上调整
    public static void shiftUp(int[] arr,int index){
        while(index > 0){
            int parent = (index-1)/2;
            if(arr[index] >= arr[parent]){
                break;
            }
            int tmp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = tmp;

            index = parent;
        }
    }
    //向下调整
    public static void shiftDown(int[] arr,int size,int index){
        int child = index * 2 + 1;
        while(child < size){
            if(child + 1 < size){
                child = arr[child] < arr[child+1]? child : child+1;
            }
            if(arr[index] <= arr[child]){
                break;
            }
            int tmp = arr[child];
            arr[child] = arr[index];
            arr[index] = tmp;

            index = child;
            child = index*2 + 1;
        }
    }
    //创建堆
    public static void createHeap(int[] arr){
        for(int i = 0;i < arr.length/2;i++){
            shiftDown(arr,arr.length,i);
        }
    }
}
