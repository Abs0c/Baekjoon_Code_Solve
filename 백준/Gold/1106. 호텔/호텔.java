import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer sk;
    static int answer = 100001;
    public static void main(String[] args) throws IOException{
        sk = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(sk.nextToken());
        int n = Integer.parseInt(sk.nextToken());
        
        int dp[] = new int[c+100]; 
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			sk = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(sk.nextToken());
			int customer = Integer.parseInt(sk.nextToken());
			
			for(int j=customer; j<c+100; j++) {
				if (dp[j-customer] != Integer.MAX_VALUE) 
					dp[j] = Math.min(dp[j], cost+dp[j-customer]);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i=c; i<c+100; i++) {
			answer = Math.min(answer, dp[i]);
		}
		System.out.println(answer);
    }
}
