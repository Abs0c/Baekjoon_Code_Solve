import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_16173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(sk.nextToken());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(sk.nextToken());
            }
        }

        if (dfs(n, arr)[n-1][n-1] == true){
            bw.write("HaruHaru");
        }
        else{
            bw.write("Hing");
        }
        br.close();
        bw.close();
    }

    public static boolean[][] dfs(int size, int[][] board){
        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[size][size];
        visited[0][0] = true;
        stack.add(new int[]{0, 0});

        while(stack.isEmpty()!=true){
            int[] visit = stack.pop();
            int x = visit[0];
            int y = visit[1];
            int gowalk = board[x][y];
            visited[x][y] = true;

            if (board[x][y] == -1){
                visited[x][y] = true;
                break;
            }

            if ((x + gowalk) < size){
                if (visited[x+gowalk][y] == false){
                    visited[x+gowalk][y] = true;
                    stack.add(new int[]{x+gowalk, y});
                }                
            }
            if ((y + gowalk) < size){
                if (visited[x][y+gowalk] == false){
                    visited[x][y+gowalk] = true;
                    stack.add(new int[]{x, y+gowalk});
                }
            }
        }
        return visited;
    }
}
