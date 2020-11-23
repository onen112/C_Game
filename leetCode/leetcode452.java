import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/** 
 * 题目:
 *      https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 思路：
 *      先对气球的位置进行排序，优先按照左侧的位置排序，如果左侧开始位置相等，则看右边的位置
 *      然后把排序后的每个气球放置到List中（方便修改和删除）
 *      开始遍历list中的元素，如果当前的气球的右侧大于下一个气球的左侧则合并两个气球（删掉当前气球和下一个气球，放入合并后的数组）
 *      直到结束，返回list中剩余的气球数，就是需要的最少的箭数
 *      
 * */ 
public class leetcode452 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(findMinArrowShots(a));
    }
    public static int findMinArrowShots(int[][] points) {
        int add = 0;
        int balloon = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < 0&&o2[0] >= 0){
                    return -1;
                }else if(o1[0] >= 0&&o2[0] < 0){
                    return 1;
                }
                if(o1[0] == o2[0]){
                    if(o1[1] < 0&&o2[1] >= 0){
                        return -1;
                    }else if(o1[1] >= 0&&o2[1] < 0){
                        return 1;
                    }
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<int[]> l = new ArrayList<>();
        for(int i = 0;i < points.length;i++){
            l.add(points[i]);
        }

        for(int i = 0;i < l.size()-1;i++){
            if(l.get(i)[1] >= l.get(i+1)[0]){
                int[] a = new int[2];
                a[0] = l.get(i+1)[0];
                a[1] = l.get(i)[1] > l.get(i+1)[1]?l.get(i+1)[1]:l.get(i)[1];
                l.remove(i);//删除当前元素
                l.remove(i);//删除下一个（这个删除后下一个就到了当前i的位置）
                l.add(i,a);
                i--;
                //修改后下次继续从i这里开始
            }
        }
        return l.size();
    }
}