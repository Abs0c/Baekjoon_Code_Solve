import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2606 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n+1];
        
        int[][] graph = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            graph[a][b] = b;
            graph[b][a] = a;
        }

        int cnt = -1;
        for (boolean temp : bfs(graph, visited)){
            if (temp == true){
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    public static boolean[] bfs(int[][] graph, boolean[] visited){
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);

        while(!queue.isEmpty()){
            int x = queue.poll();
            
            for(int i = 0; i < graph[x].length; i++){
                if (graph[x][i] != 0){
                    int temp = graph[x][i];
                    if (visited[temp] == false){
                        visited[temp] = true;
                        queue.offer(temp);
                    }
                }
            }
        }

        return visited;
    }
}
