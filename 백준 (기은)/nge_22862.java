import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_22862 {
    static int[] S; // 수열
    static boolean[] visited;
    static int max = 0;
    static int n; // 수열의 길이
    static int k; // 삭제해야할 원소의 개수
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 길이 및 삭제해야할 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        S = new int[n];

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        sol(n,k);
    }

    static void sol(int n, int k) {
        int l = 0;
        int r = 0;
        int ct = 0; // l ~ r 범위 사이의 홀수의 개수
        int maxLen = 0;

        while(r < n) {
            if(ct < k) {
                if(S[r] % 2 != 0) {
                    ct++;
                }
                r++;

                maxLen = Math.max(maxLen, r - l - ct);
            }

            else if(S[r] % 2 == 0) {
                r++;
                maxLen = Math.max(maxLen, r - l - ct);
            }

            else {
                if(S[l] % 2 != 0) {
                    ct--;
                }
                l++;
            }
        }

        System.out.println(maxLen);
    }
}