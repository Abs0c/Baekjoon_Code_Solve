import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int k = Integer.parseInt(sk.nextToken());
        int[] arr = new int[n+1];
        int[] prefixSum = new int[n+1];

        sk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(sk.nextToken());
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        int max = -10001;
        int tempValue = 0;
        for (int i = k; i <= n; i++){
            tempValue = prefixSum[i] - prefixSum[i-k];
            if (max < tempValue){
                max = tempValue;
            }
        }
        System.out.println(max);
    }    
}
