import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            hashset.add(nums[i]);
        }
        
        int n = nums.length / 2;
        if (n < hashset.size()){
            answer = n;
        }
        else{
            answer = hashset.size();
        }
        
        return answer;
    }
}