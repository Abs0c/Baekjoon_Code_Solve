import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfsExample {
    public static boolean[] bfs(int size, int start, ArrayList<ArrayList<Integer>> graph){
        
        boolean[] visited = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visited[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
        return visited;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        
        list.stream().forEach(str -> {
            System.out.println(str);
        });

        Map<String, String> map = new HashMap<String, String>(); 

        map.forEach((key, str) -> {
          System.out.println(key);
          System.out.println(str);  
        });

        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            temp.add(a)
        }
        for(int i = 0; i < n; i++){
            System.out.println(graph.get(i));
        }
        
        System.out.println(bfs(n+1, graph.get(0).get(0), graph));
        br.close();
    }
}