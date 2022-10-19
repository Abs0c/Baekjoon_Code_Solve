package code_list;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());

        br.close();

        int[] arr = new int[n];
        boolean[] visited = new boolean[n+1];

        
    }

    public static void backtracking(int[] arr, boolean[] visited, int numsize, int size){
        if (arr.length == size){
            return;
        }
        for(int i = 1; i <= numsize; i++){
            if (!visited[i]){
                
            }
        }
    }
}
