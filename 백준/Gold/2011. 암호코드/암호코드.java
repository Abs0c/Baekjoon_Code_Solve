import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String n = br.readLine();
        long[] dp = new long[n.length()+1];
        dp[0]=1;
        dp[1]=1;

        if(n.charAt(0)=='0'){
            System.out.println(0);
            return;
        }

        for(int i = 1; i < n.length(); i++) {
            char pri = n.charAt(i - 1);
            if(n.charAt(i) >= '1' && n.charAt(i)<='9'){
                dp[i+1]+=dp[i];
                dp[i+1]%=1000000;
            }
            if (!(pri == '0' || pri > '2' || (pri == '2' && n.charAt(i) > '6'))) {
                dp[i + 1] += dp[i-1];
                dp[i+1]%=1000000;
            }
            dp[i + 1] %= 1000000000;
        }

        System.out.println(dp[n.length()]%1000000000);
    }
}