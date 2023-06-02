import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer sk;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[501][501];
        int[][] cnt = new int[501][501];
        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++){
                arr[i][j] = Integer.parseInt(sk.nextToken());
            }
        }

        cnt[0][0] = arr[0][0];
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i+1; j++){
                if (j==0){
                    cnt[i][j]=arr[i][j]+cnt[i-1][j];
                }
                else{
                    cnt[i][j]=arr[i][j]+Math.max(cnt[i-1][j],cnt[i-1][j-1]);
                }
            }
        }
        int max=0;
        for (int i = 0; i < n; i++){
            if (max < cnt[n-1][i]){
                max = cnt[n-1][i];
            }
        }
        System.out.println(max);
    }
}
