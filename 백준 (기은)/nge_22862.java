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
        search(0,0);
        System.out.println(max);
    }

    static void search(int curNum, int cnt) {
        if(cnt == k) {
            // 연속하는 짝수 수열의 갯수 구하기
            int ans = getAns();

            if(max < ans) {
                max = ans;
            }

            visited[curNum] = false;
            return;
        }

        else {
            for(int i = curNum; i < n; i++) {
                visited[i] = true;
                search(i,cnt + 1);
                visited[i] = false;
            }
        }
    }

    static int getAns() {
        int maxSave = 0;
        int save = 0;

        for(int i = 0; i < n; i++) {
            if(S[i] % 2 == 0 && !visited[i]) {
                save++;

                if(maxSave < save) {
                    maxSave = save;
                }
            }

            else if (S[i] % 2 != 0 && !visited[i]){
                save = 0;
            }
        }

        return maxSave;
    }
}
