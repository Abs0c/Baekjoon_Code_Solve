import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++){
            StringTokenizer sk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(sk.nextToken());
            int m = Integer.parseInt(sk.nextToken());
            int[] parent = new int[n+1];
            for (int j = 1; j <= n; j++){
                parent[j] = j;
            }
            int val = 0;
            for (int j = 0; j < m; j++){
                sk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(sk.nextToken());
                int b = Integer.parseInt(sk.nextToken());
                val = union_parent(++val, parent, a, b);
            }
            System.out.println(val);
        }
    }

    public static int find_parent(int[] parent, int x){
        if (parent[x] != x){
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }

    public static int union_parent(int val, int[] parent, int x, int y){
        x = find_parent(parent, x);
        y = find_parent(parent, y);
        if (x < y){
            parent[y] = x;
        }
        else if (y < x){
            parent[x] = y;
        }
        else{
            val--;
        }
        return val;
    }
}