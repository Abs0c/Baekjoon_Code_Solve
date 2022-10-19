package code_list;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2210_backtracking {
    static int[][] go = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static ArrayList<String> solvearr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;
        int[][] arr = new int[5][5]; 

        for (int i = 0; i < 5; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(sk.nextToken());
            }
        }
        
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                dfs(arr, new int[6] , i, j, 0);
            }
        }
        //for(int i = 0; i < solvearr.size(); i++){
        //    System.out.println(solvearr.get(i));
        //}
        System.out.println(solvearr.size());
    }

    public static void dfs(int[][] graph, int[] temparr, int x, int y, int depth){
        if (depth == 6){
            String tempstr = Arrays.toString(temparr);
            if (!solvearr.contains(tempstr)){
                solvearr.add(tempstr);
            }            
            return;
        }
        temparr[depth] = graph[x][y];
        for (int i = 0; i < 4; i++){
            if ((0 <= (go[i][0] + x) && (go[i][0] + x) < 5) && (0 <= (go[i][1] + y) && (go[i][1] + y) < 5)){
                dfs(graph, temparr, go[i][0] + x, go[i][1] + y, depth+1);
            }
        }
    }
}
