import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sk;
        int n = Integer.parseInt(br.readLine());
        sk = new StringTokenizer(br.readLine());
        int[] cntarr = new int[20000001];

        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(sk.nextToken());
            cntarr[temp+10000000] += 1;
        }

        int m = Integer.parseInt(br.readLine());
        sk = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++){
            int temp = Integer.parseInt(sk.nextToken());
            bw.write(cntarr[temp+10000000] + " ");
        }

        br.close();
        bw.close();
    }
}
