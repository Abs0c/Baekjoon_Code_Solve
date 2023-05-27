import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer sk;
    public static int[] parents;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> arr;
    public static int n;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        parents = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < n+1; i++){
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++){
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        bfs();

        for (int i = 2; i <= n; i++){
            System.out.println(parents[i]);
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for (int i = 0; i < arr.get(temp).size(); i++){
                if (visited[arr.get(temp).get(i)] == true){
                    continue;
                }
                queue.add(arr.get(temp).get(i));
                visited[arr.get(temp).get(i)] = true;
                parents[arr.get(temp).get(i)] = temp;
            }
        }
    }
}
