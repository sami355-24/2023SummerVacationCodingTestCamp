import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_14226 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine()); // 만들고 싶은 이모티콘 갯수
        System.out.println(sol(s));
    }

    static int sol(int s) {
        int ans = 0;
        int[] dp = new int[1001];
        dp[1] = 0;

        for(int i = 2; i <= 1000; i++) {
            dp[i] = i;
        }

        for(int i = 4; i <= 1000; i++) {
            if(i % 2 == 0) {
                if(dp[i] > dp[i / 2] + 2) {
                    dp[i] = dp[i / 2] + 2;
                }
            }
        }

        for(int i = 4; i < 1000; i++) {
            if(dp[i] > dp[i + 1] + 1) {
                dp[i] = dp[i + 1] + 1;
            }
        }

        ans = dp[s];
        
        return ans;
    }
}
