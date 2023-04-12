import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], 1); 
        }
        
        for (int i = 0; i < phone_book.length; i++){
            for (int j = 0; j < phone_book[i].length(); j++){
                String temp = phone_book[i].substring(0, j);
                if (map.getOrDefault(temp, 0) == 1){
                    return false;
                }
            }
        }
        
        return true;
    }
}