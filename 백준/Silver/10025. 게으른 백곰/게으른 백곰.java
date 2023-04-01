import java.util.*;
import java.io.*;

public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int k = Integer.parseInt(sk.nextToken());
        int ans = 0;
        int[] pos = new int[1000002];
        int[] ice = new int[1000002];
        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(sk.nextToken());
            int x = Integer.parseInt(sk.nextToken());
            ice[x] = g;
        }
        pos[0] = ice[0];
        for (int i = 1; i <= 1000000; i++)
        {
            pos[i] = pos[i - 1] + ice[i];
        }
        if (k <= 1000000)
        {
            for (int i = 0; i <= 1000000; i++)
            {
            //현재위치 - k이전애들을 빼줘야함
            if (i + k <= 1000000 && i-k >=1)
                ans = Integer.max(ans, pos[i + k] - pos[i - k - 1]);
            }
            System.out.println(ans);
        }
        else
            System.out.println(pos[1000000]);
        }
}