import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer sk;
    public static void main(String[] args) throws IOException{
        sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int k = Integer.parseInt(sk.nextToken());
        boolean[] checkArr = new boolean[1001];
        Arrays.fill(checkArr, true);
        ArrayList<Integer> removeTime = new ArrayList<>();

        checkArr[0] = false;
        checkArr[1] = false;

        for (int i = 2; i < n + 1; i++){
            if (checkArr[i] == false){
                continue;
            }
            int j = 1;
            while(i * j <= n){
                if (checkArr[i * j] == true){
                    checkArr[i * j] = false;
                    removeTime.add(i * j);
                }
                j++;
            }
        }
        System.out.println(removeTime.get(k-1));
    }
}
