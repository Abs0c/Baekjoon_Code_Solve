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
        String[][] name = new String[n][2];
        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            name[i][0] = sk.nextToken();
            name[i][1] = sk.nextToken();
        }
        Arrays.sort(name, (o1, o2) -> {
            return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
        });
        for (int i = 0; i < m; i++){
            int temp = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;
            int index = 0;
            while (start <= end){
                int mid = (start + end) / 2;
                if (Integer.parseInt(name[mid][1]) < temp){
                    start = mid + 1;
                    index = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            bw.write(name[index][0]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
