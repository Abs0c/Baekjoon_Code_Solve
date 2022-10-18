import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class baek_7576 {
    public static int[][] go = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void bfs(Deque<int[]> queue, int[][] graph, int sizex, int sizey, int[][] visited){
        while(!queue.isEmpty()){
            int[] temparr = queue.pop();
            int tx = temparr[0];
            int ty = temparr[1];
            for (int i = 0; i < 4; i++){
                int tempx = go[i][0] + tx;
                int tempy = go[i][1] + ty;
                if ((0 <= tempx && tempx < sizex) && (0 <= tempy && tempy < sizey)){
                    if (visited[tempx][tempy] <= 0){
                        if (graph[tempx][tempy] == 0){
                            graph[tempx][tempy] = 1;
                            visited[tempx][tempy] = visited[tx][ty] + 1;
                            queue.add(new int[]{tempx, tempy});
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(sk.nextToken());
        int n = Integer.parseInt(sk.nextToken());
        int[][] visited = new int[n][m];
        int[][] graph = new int[n][m];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(sk.nextToken());
                if(graph[i][j] == 1){
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
                else if (graph[i][j] == -1){
                    visited[i][j] = -1;
                }
            }
        }
        bfs(queue, graph, n, m, visited);
        int result = 0;
        for(int i = 0; i < n; i++){
            if (result == -1){
                break;
            }
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0){
                    result = -1;
                    break;
                }
                else{
                    result = Math.max(result, visited[i][j]-1);
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
