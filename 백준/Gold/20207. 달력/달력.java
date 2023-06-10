import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer sk;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[366];

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            for (int j = a; j <= b; j++){
                cnt[j]++;
            }
        }

        int sum = 0;
        int maxa = 0;
        int b = 0;

        for (int i = 0; i < 366; i++){
            if (cnt[i]==0){
                sum += maxa * b;
                maxa = 0;
                b = 0;
                continue;
            }
            b++;
            maxa = Math.max(maxa, cnt[i]);
        }
        sum += maxa * b;
        System.out.println(sum);
    }
}
