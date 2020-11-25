import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * 题目：
 *      https://leetcode-cn.com/problems/increasing-decreasing-string/
 * 
 */
public class leetcode1370 {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }
    public static String sortString(String s) {
        String ret = "";
        Map<Character,Integer> m = new HashMap<>();
        List<int[]> l = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            if(m.get(s.charAt(i)) == null)
                m.put(s.charAt(i),1);
            else
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
        }
        for(char c : m.keySet()){
            int[] a = new int[2];
            a[0] = c - 'a';
            a[1] = m.get(c);
            l.add(a);
        }

        l.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
//        int i = 0;
//        int j = 1;
        for(int[] a : l){
            System.out.println((char)(a[0] + 'a'));
        }

        while(!l.isEmpty()){
            for(int i = 0;i < l.size();i++){
                int[] a = l.get(i);
                a[1]--;
                if(a[1] == 0){
                    l.remove(i);
                    if(!l.isEmpty()){
                        i--;
                    }
                }
                ret += (char)(a[0] + 'a');
            }

            for(int i = l.size()-1;i >= 0;i--){
                int[] a = l.get(i);
                a[1]--;
                if(a[1] == 0){
                    l.remove(i);
                }
                ret += (char)(a[0] + 'a');
            }
        }
        return ret;
    }
}