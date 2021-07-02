/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 
 * 根据字符出现频率排序
 * 
 * 首先统计每个字符的出现次数 
 * 然后使用Arrays.sort() 重写 Comparator接口的方法 用 map.get(array[i])作为比较条件
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);

        }
        Set set = map.keySet();
        Character[] array = new Character[set.size()];
        int index = 0;
        for(char c : map.keySet()){
            array[index++] = c;
        }
        Arrays.sort(array, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();

          for(index = 0;index < array.length;index++){
            for(int i = 0;i < map.get(array[index]);i++){
                sb.append(array[index]);
            }
            
        }

        return sb.toString();


    }
}