import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        HashSet<Integer> edge = new HashSet<Integer>();
        HashSet<Integer> onList = new HashSet<Integer>();
        
        for (int num = 0; num < n; num++){
            int[] cnt = new int[n+1];
            int remainsCnt = 0;
            int[][] remainsList = new int[lighthouse.length][2];
        
            for (int i = 0; i < lighthouse.length; i++){
                cnt[lighthouse[i][0]]++;
                cnt[lighthouse[i][1]]++;
            }
        
            for (int i = 0; i < cnt.length; i++){
                if (cnt[i] == 1){
                    edge.add(i);
                }
            }
            
            for (int i = 0; i < lighthouse.length; i++){
                if (edge.contains(lighthouse[i][0])){
                    onList.add(lighthouse[i][1]);
                }
                else if (edge.contains(lighthouse[i][1])){
                    onList.add(lighthouse[i][0]);
                }
            }
            
        
            for (int i = 0; i < lighthouse.length; i++){
                if (!onList.contains(lighthouse[i][0]) && !onList.contains(lighthouse[i][1])){
                    remainsList[remainsCnt] = lighthouse[i];
                    remainsCnt++;
                }
            }
        
            if (remainsCnt == 0){
                break;
            }
            else if (remainsCnt == 1){
                answer += 1;
                break;
            }
            else{
                lighthouse = new int[remainsCnt][2];
                for (int i = 0; i < remainsCnt; i++){
                    lighthouse[i] = remainsList[i];
                }
            }
        }
        
        answer += onList.size();
        return answer;
    }
}