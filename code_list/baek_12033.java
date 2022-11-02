package code_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_12033 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t ; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[2 * n];
            StringTokenizer sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 * n; j++){
                arr[j] = Integer.parseInt(sk.nextToken());
            }
            backtracking(0, arr, n, new int[n], new boolean[2 * n], i+1);
        }
        br.close();
    }
    public static int ispossible(int a, int nowind, int[] arr, boolean[] isused){
        for (int i = 0; i < arr.length; i++){
            if (isused[i] == false){
                if (a / 3 * 4 == arr[i]){
                    return i;
                }
            }
        }
        return 0;
    }
    public static void backtracking(int t, int[] arr, int n,  int[] ansarr, boolean[] isused, int tt){
        if (t == n){
            System.out.print("Case #"+ tt +": ");
            for(int i = 0; i < n; i++){
                System.out.print(ansarr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n * 2; i++){
            if (isused[i] == false){
                int compval = ispossible(arr[i], i, arr, isused);
                if (compval != 0){
                    isused[compval] = true;
                    isused[i] = true;
                    ansarr[t] = arr[i];
                    backtracking(t+1, arr, n, ansarr, isused, tt);
                }
            }
        }
    }
}
