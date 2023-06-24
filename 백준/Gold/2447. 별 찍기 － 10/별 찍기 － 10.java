import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        star(0, 0, n, false);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void star(int x, int y, int size, boolean isBlank){
        if(isBlank){
            for (int i = x; i < x + size; i++){
                for (int j = y; j < y + size; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1){
            arr[x][y] = '*';
            return;
        }

        int tempSize = size / 3;
        int cnt = 0;
        for (int i = x; i < x + size; i += tempSize){
            for (int j = y; j < y + size; j += tempSize){
                if (cnt == 4){
                    star(i, j, tempSize, true);
                }
                else{
                    star(i, j, tempSize, false);
                }
                cnt++;
            }
        }
    }
}
