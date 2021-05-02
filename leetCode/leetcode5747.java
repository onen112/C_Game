/**
 * 题目：https://leetcode-cn.com/problems/splitting-a-string-into-descending-consecutive-values/submissions/
 * 
 * 将字符串拆分为递减的连续值
 * 
 * 思路：dfs然后判断 小优化
 */

class Solution {
    boolean ret = false;
    public boolean splitString(String s) {
        for(int i = 1;i < s.length();i++){
            List<String> list = new ArrayList<>();
            list.add(s.substring(0,i));
            list.add(s.substring(i,s.length()));
            if(isSplit(list)){
                return true;
            }
            dfs(list);
            if(ret){
                return true;
            }
        }
        return ret;
    }
    //判断是否满足条件
    public boolean isSplit(List<String> list){
        for(int i = 0;i < list.size()-1;i++){
           try{
                if(Long.parseLong(list.get(i)) - Long.parseLong(list.get(i+1)) != 1){
                    return false;
                }
           }catch(Exception e){
               return false;
           }
            
        }
        return true;
    }
    public void dfs(List<String> list){
        String tmp = list.get(list.size()-1);

        for(int i = 1;i < tmp.length();i++){
            if(ret){
                return;
            }
            List<String> tmpL = new ArrayList<>();
            tmpL.addAll(list);
            tmpL.remove(tmpL.size()-1);
            tmpL.add(tmp.substring(0,i));
            tmpL.add(tmp.substring(i,tmp.length()));
            if (isSplit(tmpL)) {
                ret = true;
                return;
            }
            //长度大于2切不满足前两个数递减直接不走
            if(tmpL.size() >2 && Long.parseLong(tmpL.get(0))-Long.parseLong(tmpL.get(1)) != 1){
                
            }else{
                dfs(tmpL);
            }
            
        }
    }
    
}