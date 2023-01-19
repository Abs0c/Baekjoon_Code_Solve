import java.util.*;
import java.io.*;

class Solution {
    public static int[][] go = {{1 ,0}, {0, 1}, {-1, 0}, {0, -1}};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];
        visited[n-1][m-1] = -1;
        int answer = bfs(maps, 1, n, m, visited);
        return answer;
    }
    public int bfs(int[][] maps, int answer, int n, int m, int[][] visited){
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0});
        visited[0][0] = answer;
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++){
                if (0 <= go[i][0] + x && go[i][0] + x < n && 0 <= go[i][1] + y && go[i][1] + y < m){
                    if (visited[go[i][0] + x][go[i][1] + y] <= 0 && maps[go[i][0] + x][go[i][1] + y] == 1){
                        queue.add(new int[]{go[i][0] + x, go[i][1] + y});
                        visited[go[i][0] + x][go[i][1] + y] = visited[x][y] + 1;
                    }
                }
            }
        }
        return visited[n-1][m-1];
    }
}