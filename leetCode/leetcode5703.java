/**
 * 题目：https://leetcode-cn.com/problems/maximum-average-pass-ratio/
 * 
 * 最大平均通过率
 * 
 * 思路：
 *      用一个优先队列 按照 (o1[0]+1)/(o1[1]+1)-o1[0]/o1[1])降序排序
 *      每次取出队头加一放回 直到 k 等于0 
 */
class Solution {
    public double maxAverageRatio(int[][] classes, int k) {
         PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(((o1[0]+1)/(o1[1]+1)-o1[0]/o1[1]) - ((o2[0]+1)/(o2[1]+1) - o2[0]/o2[1]) > 0){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    );
        double ret = 0;
        for (int i = 0; i < classes.length; i++) {
            double[] tmp = new double[2];
            tmp[0] = classes[i][0];
            tmp[1] = classes[i][1];
            
            pq.offer(tmp);
            ret +=  tmp[0] /  tmp[1];
        }
        while (k != 0) {
            double[] poll = pq.poll();
            ret -= poll[0] /poll[1];
            poll[0]++;
            poll[1]++;
            ret += poll[0]/poll[1];
            pq.offer(poll);
            k--;

        }
        return ret/ classes.length;
    }
}