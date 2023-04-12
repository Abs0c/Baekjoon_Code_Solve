import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry<String, Integer> temp = iter.next();
            answer *= (temp.getValue()+1);
        }
        return answer - 1;
    }
}