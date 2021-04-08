/**
 * 题目：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 
 * 数组中的逆序对
 * 
 * 思路：
 *      用归并排序的方式 计算其中交换的次数返回即可
 */
class Solution {
    int ret;
    public int reversePairs(int[] nums) {
        this.ret = 0;
        contSort(nums,0,nums.length-1);
        return ret;
    }
    public void contSort(int[] arr,int l,int r){
        if(l >= r) return; 
        int m = (l+r)/2;
        contSort(arr,l,m);
        contSort(arr,m+1,r);
        int[] tmp = new int[r-l+1];
        //合并时 从后往前合并
        int i = m;
        int j = r;
        int n = tmp.length-1;
        while(i >= l && j >= m+1){
            if(arr[i] > arr[j]){
                this.ret+=j-m;
                tmp[n--] = arr[i--];
            }else{
                tmp[n--] = arr[j--];
            }
        }
        while(i >= l){
            tmp[n--] = arr[i--];
        }
        while(j >= m+1){
            tmp[n--] = arr[j--];
        }
        j = 0;
        for(i = l;i <= r;i++,j++){
            arr[i] = tmp[j];
        }
    }
}