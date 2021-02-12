/**
 * 题目：https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 
 * 杨辉三角2
 * 
 * 返回杨辉三角指定的行的元素
 * 
 * 思路
 *      用队列先进先出的特性  每次保留杨辉三角上一行的值
 *      然后通过计算更新需要返回的数组
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if(rowIndex == 0){
            ret.add(1);
        }else if(rowIndex == 1){
            ret.add(1);
            ret.add(1);
        }else{
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            queue.offer(1);
            rowIndex -= 1;
            int num2;
            int num1;
            while(rowIndex > 0){ 
                while(!queue.isEmpty()){   
                    num1 = queue.poll();
                    if(queue.peek() != null){
                        num2 = queue.peek();
                    }else{
                        num2 = 0;
                    }
                    if(num1 == 1&&num2 != 0){
                        ret.add(num1);
                        ret.add(num1 + num2);
                    }else if(num1 != 1){
                        ret.add(num2 + num1);
                    }else{
                        ret.add(num1);
                    }
                }
                rowIndex--;
                if(rowIndex == 0) break;
                for(int i : ret){
                    queue.offer(i);
                }
                ret.clear();
            }
        }
        return ret;
    }
}