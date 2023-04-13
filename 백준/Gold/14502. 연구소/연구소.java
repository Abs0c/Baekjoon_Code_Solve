import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n = 0;
    public static int m = 0;
    public static int[][] arr;
    public static int maxSafeZone = 0;
    public static int[][] go = {{-1 , 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException{
        StringTokenizer sk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sk.nextToken());
        m = Integer.parseInt(sk.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    public static void dfs(int wallcnt){
        if (wallcnt == 3){
            bfs();
            return;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(wallcnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        int[][] tempArr = new int[n][m];
        for (int i = 0; i < n; i++){
            tempArr[i] = arr[i].clone();
        }

        Queue<int[]> queue = new LinkedList();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (tempArr[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++){
                if (x + go[i][0] >= 0 && x + go[i][0] < n && y + go[i][1] >= 0 && y + go[i][1] < m){
                    if (tempArr[x + go[i][0]][y + go[i][1]] == 0){
                        tempArr[x + go[i][0]][y + go[i][1]] = 2;
                        queue.add(new int[]{x + go[i][0], y + go[i][1]});
                    }
                }
            }
        }

        checkSafeZone(tempArr);
    }

    public static void checkSafeZone(int[][] tempArr){
        int tempCnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (tempArr[i][j] == 0){
                    tempCnt++;
                }
            }
        }

        if (maxSafeZone < tempCnt){
            maxSafeZone = tempCnt;
        }
    }
}
