import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer sk;
    static int white = 0;
    static int blue = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(sk.nextToken());
            }
        }

        divide(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
        br.close();
    }

    static void divide(int x, int y, int size){
        if (colorCheck(x, y, size)){
            if (board[x][y] == 0){
                white++;
            }
            else{
                blue++;
            }
            return;
        }

        int tempSize = size / 2;
        divide(x, y, tempSize);
        divide(x, y + tempSize, tempSize);
        divide(x + tempSize, y, tempSize);
        divide(x + tempSize, y + tempSize, tempSize);
    }

    static boolean colorCheck(int x, int y, int size){
        int color = board[x][y];

        for (int i = x; i < x + size; i++){
            for (int j = y; j < y + size; j++){
                if (board[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
