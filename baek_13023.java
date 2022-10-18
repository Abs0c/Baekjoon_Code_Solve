import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_13023 {
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        br.close();
        for(int i = 0; i < n; i++){
            dfs(graph, i, visited, 1);
            if (ans == 1){
                System.out.println(ans);
                return;
            }
        }
        System.out.println(ans);
    }
    public static void dfs(ArrayList<Integer>[] graph, int start, boolean[] visited, int depth){
        if(depth == 5){
            ans = 1;
            return;
        }
        visited[start] = true;   
        for(int i = 0; i < graph[start].size(); i++){
            if(visited[graph[start].get(i)] == false){
                dfs(graph, graph[start].get(i), visited, depth+1);
            }
        }
        visited[start]=false;
    }
}
