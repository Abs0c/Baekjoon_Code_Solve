package code_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1388 {
    static int temp = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());
        String[] arr = new String[n];
        int[][] visited = new int[n][m];
        
        for (int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }        

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                dfs(arr, i, j, visited, n, m);
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                max = Math.max(max, visited[i][j]);
            }
        }
        System.out.println(max);
    }

    public static void dfs(String[] arr, int x, int y, int[][] visited, int n, int m){
        if (visited[x][y] > 0){
            return;
        }
        visited[x][y] = temp;
        if (arr[x].charAt(y) == '-'){
            if ((y+1 < m) && (arr[x].charAt(y+1) == '-')){
                dfs(arr, x, y+1, visited, n, m);
            }
            else{
                temp++;
            }
        }
        else if (arr[x].charAt(y) == '|'){
            if ((x+1 < n) && (arr[x+1].charAt(y) == '|')){
                dfs(arr, x+1, y, visited, n, m);
            }
            else{
                temp++;
            }
        }
    }
}
