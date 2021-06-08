//埃式筛求小于一个数的所有质数 o(n)的时间复杂度
public static List<Integer> Euler(int n){
    List<Integer> list = new ArrayList<>();
    boolean[] b = new boolean[n+1];
    for(int i = 2; i <= n;i++){
        if(!b[i]){
            list.add(i);
        }
        for(int j = 0;j < list.size();j++){
            if(i*list.get(j) > n){
                break;
            }
            b[i*list.get(j)] = true;
            if(i%list.get(j) == 0){
                break;
            }
        }
    }
    return list;
} 