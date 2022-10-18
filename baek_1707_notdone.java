import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_1707_notdone {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sk;
        int x; int y;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(sk.nextToken());
            y = Integer.parseInt(sk.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[x+1];
            for (int j = 0; j < x+1; j++){
                graph[j] = new ArrayList<Integer>();
            }
            for(int j = 0; j < y; j++){
                sk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(sk.nextToken());
                int b = Integer.parseInt(sk.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            bw.write(dfs(graph, 1, x+1)+ "\n");
        }
        br.close();
        bw.close();
    }

    public static String dfs(ArrayList<Integer>[] graph, int start, int size){
        int[] visited = new int[size];
        visited[start] = 1;
        Stack<Integer> checknext = new Stack<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        String toprint = "YES";
        int temprb = -1;
        stack.add(start);
        while(!stack.isEmpty()){
            int temp = stack.pop();
            checknext.add(temp);
            for(int i = 0; i < graph[temp].size(); i++){
                if (visited[graph[temp].get(i)] == 0){
                    visited[graph[temp].get(i)] = temprb;
                    stack.add(graph[temp].get(i));
                }
            }
            temprb = temprbchange(temprb);
        }

        temprb = temprbchange(visited[checknext.peek()]);
        while(!checknext.isEmpty()){
            int bbb = checknext.pop();
            if (temprb == visited[bbb]){
                toprint = "NO";
                break;
            }
            temprb = temprbchange(temprb);
        }
        return toprint;
    }

    public static int temprbchange(int temprb){
        if (temprb == 1){
            temprb = -1;
        }
        else{
            temprb = 1;
        }
        return temprb;
    }
}
