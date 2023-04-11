import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //List처럼 저장공간을 한 칸씩 늘리지 않고 약 두배로 늘립니다. 여기서 과부하가 많이 발생합니다. 그렇기에 초기에 저장할 데이터 개수를 알고 있다면 Map의 초기 용량을 지정해주는 것이 좋습니다. 
        HashMap<String, Integer> hashmap = new HashMap<>(participant.length);
        
        for (int i = 0; i < participant.length; i++){
            hashmap.put(participant[i], hashmap.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++){
            hashmap.put(completion[i], hashmap.get(completion[i]) - 1);
        }
        
        Iterator<Map.Entry<String, Integer>> iter = hashmap.entrySet().iterator();
        
        while (iter.hasNext()){
            Map.Entry<String, Integer> next = iter.next();
            if (next.getValue() != 0){
                answer = next.getKey();
                break;
            }
        }
        
        return answer;
    }
}