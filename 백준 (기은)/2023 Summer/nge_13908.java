import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_13908 {
    static int result = 0;
    static int n;
    static int m;
    static boolean[] visited; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        m = Integer.parseInt(st.nextToken()); // 비밀번호에 들어가는 수
        visited = new boolean[10];

        if(m != 0) { // 만약 비밀번호에 들어가는 수가 0인 경우는 따로 계산 x
            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < m; i++) {
                int chs = Integer.parseInt(st.nextToken());
                visited[chs] = true;
            }
        }

        sol(0,0);
        System.out.println(result);
    }

    static void sol(int idx, int cnt) {
        if(idx == n) {
            if(cnt == m) {
                result++;
                return;
            }

            else {
                return;
            }
        }

        for(int i = 0; i <= 9; i++) {
            if(visited[i] == true) {
                visited[i] = false;

                sol(idx + 1, cnt + 1);
                visited[i] = true;
                continue;
            }

            sol(idx + 1, cnt);
        }
    }
}