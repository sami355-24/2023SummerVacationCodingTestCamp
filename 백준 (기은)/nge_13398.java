import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_13398 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sol(n);
    }

    static void sol(int n) {
        int[][] dp = new int[n][2];
        // 이때 0은 수열에서 수 제거 x 1의 경우에는 수 제거 o
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        
        int ans = arr[0]; // 0을 하면 안됨.

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);

            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

            // int tmp = Math.max(dp[i][0], dp[i][1]);
            // ans = Math.max(ans, tmp);
        }

        for(int i = 1; i < n; i++) {
            int tmp = Math.max(dp[i][0], dp[i][1]);
            ans = Math.max(ans,tmp);
        }

        System.out.println(ans);
    }
}