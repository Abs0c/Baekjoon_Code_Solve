import java.io.*;
import java.util.*;

public class Main {
    public static int n = 0;
    public static int m = 0;
    public static int[][] arr;
    public static boolean[] open;
    public static ArrayList<int[]> chickenArr;
    public static ArrayList<int[]> personArr;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sk.nextToken());
        m = Integer.parseInt(sk.nextToken());

        arr = new int[n][n];
        chickenArr = new ArrayList<>();
        personArr = new ArrayList<>();

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int temp = Integer.parseInt(sk.nextToken());
                if (temp == 2){
                    chickenArr.add(new int[]{i, j});
                }
                else if (temp == 1){
                    personArr.add(new int[]{i, j});
                }
            }
        }

        answer = Integer.MAX_VALUE;
        open = new boolean[chickenArr.size()];
        
        dfs(0, 0);
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int start, int chickenCnt){
        if (chickenCnt == m){
            checkDistance();
            return;
        }
        for (int i = start; i < chickenArr.size(); i++){
            open[i]= true;
            dfs(i + 1, chickenCnt + 1);
            open[i] = false;
        }
    }

    public static void checkDistance(){
        int cnt = 0;
        int distance = 0;
        int temp = 0;
        for (int i = 0; i < personArr.size(); i++){
            distance = Integer.MAX_VALUE;
            for (int j = 0; j < chickenArr.size(); j++){
                if (open[j] != true){
                    continue;
                }
                temp = Math.abs(personArr.get(i)[0] - chickenArr.get(j)[0]) + Math.abs(personArr.get(i)[1] - chickenArr.get(j)[1]);
                distance = Math.min(temp, distance);
            }
            cnt += distance;
        }
        answer = Math.min(answer, cnt);
    }
}
