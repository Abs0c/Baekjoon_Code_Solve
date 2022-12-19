import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //int[] arr = new int[n];
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            int sum = 0;
            int j = i;
            while (sum < n){
                sum += j;
                j++;
            }
            if (sum == n){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}