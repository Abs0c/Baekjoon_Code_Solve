import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer sk;
    static int n = 0;
    static int[][] arr;
    static int sum = 0;
    static int answer = 17*17*100 + 18 * 100;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(sk.nextToken());
                sum += arr[i][j];
            }
        }
        for (int x = 0; x < n; x++){
            for (int y = 0; y < n; y++){
                for (int d1 = 1; d1 < n; d1++){
                    for (int d2 = 1; d2 < n; d2++){
                        if (x + d1 + d2 >= n){
                            continue;
                        }
                        if (y - d1 < 0 || y + d2 >= n){
                            continue;
                        }

                        solve(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void solve(int x, int y, int d1, int d2){
        boolean[][] borders = new boolean[n][n];

        for (int i = 0; i <= d1; i++) {
            borders[x + i][y - i] = true;
            borders[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            borders[x + i][y + i] = true;
            borders[x + d1 + i][y - d1 + i] = true;
        }

        int[] sumOfPeople = new int[6];

        // 1구역
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if(borders[i][j]) break;
                sumOfPeople[1] += arr[i][j];
            }
        }

        // 2구역
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if(borders[i][j]) break;
                sumOfPeople[2] += arr[i][j];
            }
        }

        // 3구역
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if(borders[i][j]) break;
                sumOfPeople[3] += arr[i][j];
            }
        }

        // 4구역
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (borders[i][j]) break;
                sumOfPeople[4] += arr[i][j];
            }
        }

        // 5구역
        sumOfPeople[5] = sum;
        for (int i = 1; i < 5; i++) {
            sumOfPeople[5] -= sumOfPeople[i];
        }

        Arrays.sort(sumOfPeople);

        answer = sumOfPeople[5] - sumOfPeople[1] < answer ? sumOfPeople[5] - sumOfPeople[1] : answer;
    }
}
