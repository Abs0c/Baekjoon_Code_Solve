class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++){
            triangle[i][0] += triangle[i-1][0];
            for (int j = 1; j < triangle[i].length - 1; j++){
                int a = triangle[i-1][j-1];
                int b = triangle[i-1][j];
                if (a > b){
                    triangle[i][j] += a;
                }
                else{
                    triangle[i][j] += b;
                }
            }
            triangle[i][triangle[i].length - 1] += triangle[i-1][triangle[i-1].length - 1];
        }
        for (int j = 0; j < triangle[triangle.length-1].length; j++){
            if (answer < triangle[triangle.length-1][j]){
                answer = triangle[triangle.length-1][j];
            }
        }
        return answer;
    }
}