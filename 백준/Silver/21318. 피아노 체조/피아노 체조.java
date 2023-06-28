import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer sk;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] prefixSumArr = new int[n+1];
        sk = new StringTokenizer(br.readLine());

        arr[1] = Integer.parseInt(sk.nextToken());
        for (int i = 2; i <= n; i++){
            arr[i] = Integer.parseInt(sk.nextToken());
            prefixSumArr[i] += prefixSumArr[i-1];
            if (arr[i] < arr[i-1]){
                prefixSumArr[i]++;
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++){
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write((prefixSumArr[temp[1]] - prefixSumArr[temp[0]])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
