import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_15486 {
    static int[] t;
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        t = new int[n + 2];
        p = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        sol(n);
    }

    static void sol(int n) {
        int[] dp = new int[n + 2];
        int max = 0;

        for(int i = 1; i < n + 2; i++) {    
            if(max < dp[i]) {
                max = dp[i];
            }

            int day = i + t[i];

            if(day < n + 2) {
                dp[day] = Math.max(dp[day], max + p[i]);
            }
        }

        System.out.println(max);
    }
}
