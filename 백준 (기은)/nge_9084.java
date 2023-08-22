import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_9084 {
    static int n; // 동전 가지 수
    static int[][] coin; // 동전 종류 + 동전 개수
    static int[] limit; // 각 동전의 한계치
    static int count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            coin = new int[n + 1][2];
            limit = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(br.readLine());

            for(int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());
                coin[j][0] = val;
                limit[j] = m / val;
                count = 0;
                sol();
            }
        }
    }

    // 0001 0002 0003 
    static void sol() {
        coin
    }
}