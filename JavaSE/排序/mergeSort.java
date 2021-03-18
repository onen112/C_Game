/**
 * 归并排序
 * 
 * 分治在合并的思想
 * 
 * 时间复杂度：
 *      O(n*log(n)) 是一个稳定的排序算法
 * 空间复杂度：
 *      O(n)     
 */
public class merge {
    public static void mergeSort(int[] arr){
        merge(arr,0,arr.length-1);
    }
    private static void merge(int[] arr,int l,int r){
        if(l >= r) return;
        int m = (l+r)/2;
        //分
        merge(arr,l,m);
        merge(arr,m+1,r);
        int[] tmp = new int[r-l+1];
        int i = l;
        int j = m+1;
        int n = 0;
        //合并
        while(i <= m && j <= r){
            tmp[n++] = arr[i]>arr[j]?arr[j++]:arr[i++];
        }
        while(i <= m){
            tmp[n++] = arr[i++];
        }
        while(j <= r){
            tmp[n++] = arr[j++];
        }
        j = 0;
        for(i = l;i <= r;i++,j++){
            arr[i] = tmp[j];
        }
    }
}