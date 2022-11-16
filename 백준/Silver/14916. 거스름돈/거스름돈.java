import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];
        arr[1] = -1;
        arr[2] = 1;
        arr[3] = -1;
        arr[4] = 2;
        arr[5] = 1;
        
        dp(arr, n);
        System.out.println(arr[n]);
    }
    public static int dp(int[] arr, int n){
        if (arr[n] == 0){
            int nsub2 = dp(arr, n-2);
            int nsub5 = dp(arr, n-5);
            if (nsub2 + nsub5 == -2){
                arr[n] = -1;
            }
            else if (nsub2 > 0 && nsub5 > 0){
                arr[n] = Math.min(nsub2, nsub5) + 1;
            }
            else{
                arr[n] = Math.max(nsub2, nsub5) + 1;
            }
        }
        return arr[n];
    }
}
