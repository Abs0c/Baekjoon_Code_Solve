import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer sk;
    public static void main(String[] args) throws IOException{
        sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());
        int[][] arr = new int[n+1][n+1];
        int[][] prefixSumArr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(sk.nextToken());
                prefixSumArr[i][j] = prefixSumArr[i][j-1] + arr[i][j];
            }
        }

        for (int j = 0; j < m; j++){
            int sum = 0;
            int[] tempPos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int k = tempPos[0]; k <= tempPos[2]; k++){
                sum += prefixSumArr[k][tempPos[3]] - prefixSumArr[k][tempPos[1]-1];
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
