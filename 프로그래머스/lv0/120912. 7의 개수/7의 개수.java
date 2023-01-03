class Solution {
    public int solution(int[] array) {
        int answer = 0 ;
        for (int i = 0; i < array.length; i++){
            int temp = array[i];
            for (int j = 0; j < (array[i]+"").length(); j++){
                if (temp % 10 == 7){
                    answer++;
                }
                temp /= 10;
            }
        }
        return answer;
    }
}