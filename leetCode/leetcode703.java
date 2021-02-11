/**
 * 题目：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 
 * 数据流中的第k大元素
 * 
 * 思路
 *      使用list存储
 *      第一次存入时对list中的元素进行降序排序
 *      之后每次添加在list中找何时的位置进行插入
 *      并返回第k-1个元素
 */
class KthLargest {
    private List<Integer> list;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public int add(int val) {
        if(list.size() == 0){
            list.add(val);
        }
        else if(val >= list.get(0)){
            list.add(0,val);
        }else if(val <= list.get(list.size()-1)){
            list.add(list.size(),val);
        }else {
            int i = 1;
            for (; i < list.size()&&i < k; i++) {
                if (val < list.get(i - 1) && val >= list.get(i)) {
                    list.add(i, val);
                }
            }
        }
        return list.get(this.k-1);
    }
}