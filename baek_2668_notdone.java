import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class baek_2668_notdone {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n+1];
        ArrayList<Integer>[] ans = new ArrayList[n+1];

        for(int i = 1; i < n+1; i++){
            ans[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i < n+1; i++){
            int temp = Integer.parseInt(br.readLine());
            graph[i] = temp;
            dfs(graph, i);
        }

    }
    public static ArrayList<Integer> dfs(int[] graph, int start){
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> visited2 = new ArrayList<>();

        stack.add(start);

        while(!stack.isEmpty()){
            int temp = stack.pop();
            if (!visited.contains(temp)){
                visited.add(temp);
                stack.add(graph[temp]);
                visited2.add(graph[temp]);
            }            
        }

        for(int i = 0; i < visited.size(); i++){
            System.out.print(visited.get(i) + "/" + visited2.get(i) + " ");
        }
        System.out.println();
        return visited;
    }
}
