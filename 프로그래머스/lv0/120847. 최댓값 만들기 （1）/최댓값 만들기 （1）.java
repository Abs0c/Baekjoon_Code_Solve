class Solution {
    public int solution(int[] numbers) {
        int a = 0; int b = 0;
        for (int i = 0; i < numbers.length; i++){
            if (a < numbers[i]){
                b = a;
                a = numbers[i];
            }
            else if (b < numbers[i]){
                b = numbers[i];
            }
        }
        return a*b;
    }
}