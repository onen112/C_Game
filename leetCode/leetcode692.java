/**
 * 题目：https://leetcode-cn.com/problems/top-k-frequent-words/
 * 前k个高频单词
 * 
 * 统计一个字符串数组中出现次数前k多的单词
 * 
 * 思路：
 *      先用map对字符串中的每个单词数目进行统计
 *      单词作为k，出现次数作为value
 *      然后把Map中的每个k放到优先队列中
 *      并修改优先队列的排序规则，按照在map中的value大小进行排序
 *      取出前k个即可
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        //将单词放置到map中
        for(int i = 0;i < words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<String> ret = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            //  修改优先队列的比较规则，如果value值不想等按value排序，如果相等，按照字符串大小排序
            public int compare(String o1, String o2) {
                int ret = map.get(o2) - map.get(o1);
                if(ret != 0)
                    return ret;
                return o1.compareTo(o2);
            }
        });
        //将key放置到优先队列中
         for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry.getKey());
        }
        //取出前k个
        for(;k >0;k--){
            ret.add(pq.poll());
        }
        return ret;
    }
}