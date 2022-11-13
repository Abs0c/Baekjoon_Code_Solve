import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[15][15];
        for (int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            dp(arr, k, n);
            System.out.println(arr[k][n]);
        }
    }

    public static void dp(int[][] arr, int k, int n){
        if (k == 0){
            if (arr[k][n] == 0){
                arr[k][n] = n;
            }
            return;
        }
        int temp = 0;
        for(int i = 1; i <= n; i++){
            dp(arr, k-1, i);
            temp += arr[k-1][i];
        }
        arr[k][n]= temp;
    }
}