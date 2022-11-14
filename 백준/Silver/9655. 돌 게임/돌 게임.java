import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        arr[1] = 1;//SK
        arr[2] = -1;//CY
        arr[3] = 1;//SK
        if (dp(arr, n) == 1){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }

    public static int dp(int[] arr, int n){
        if (arr[n] == 0){
            if (n > 3){
                arr[n] = dp(arr, n-3) * -1;
            }
            else{
                arr[n] = dp(arr, n-1) * -1;
            }
        }
        return arr[n];
    }
}