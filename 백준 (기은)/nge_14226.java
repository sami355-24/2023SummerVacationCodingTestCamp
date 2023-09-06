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
        int[] dp = new int[s + 1];
        dp[1] = 1;

        return ans;
    }
}
