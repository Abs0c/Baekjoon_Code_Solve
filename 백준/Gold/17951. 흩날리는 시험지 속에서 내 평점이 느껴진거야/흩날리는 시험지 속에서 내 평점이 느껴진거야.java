import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer sk;
    public static void main(String[] args) throws IOException{
        sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int k = Integer.parseInt(sk.nextToken());
        int[] arr = new int[n];
        sk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(sk.nextToken());
        }

        int answer = 0;
        int left = 0;
        int right = (int)Math.pow(10, 5) * 20 + 1;
        while (left <= right){
            int mid = (left + right) / 2;
            int score = 0;
            int groupCnt = 0;
            for (int i = 0; i < n; i++){
                if (score + arr[i] >= mid){
                    score = 0;
                    groupCnt += 1;
                }
                else{
                    score += arr[i];
                }
            }

            if (groupCnt < k){
                right = mid - 1;
            }
            else if (groupCnt == k){
                answer = Math.max(mid, answer);
                left = mid + 1;
            }
            else{
                left = mid + 1;
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
