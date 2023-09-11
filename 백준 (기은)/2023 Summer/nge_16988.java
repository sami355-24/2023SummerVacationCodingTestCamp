import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nge_16988 {
    static int n; // 바둑판의 행
    static int m; // 바둑판의 열
    static int[][] map; // 바둑판
    static int total = 0; // 죽일 수 있는 상대돌의 개수
    // 상하좌우
    static int[] dir_r = {-1,1,0,0};
    static int[] dir_c = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(0,0,0);

        System.out.println(total);
    }

    static void sol(int r, int c, int dep) {
        if(dep == 2) {
            // 1로 둘러싸였는지 여부확인
            arroundFor1();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    sol(i,j,dep + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void arroundFor1() {
        boolean visited[][] = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2 && visited[i][j] == false) {
                    cnt += bfs(visited,i,j);
                }
            }
        }
        total = Math.max(total,cnt);
    }

    static int bfs(boolean[][] visited, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean zerochk = false;
        q.add(new int[] {r,c});
        int cnt = 1;
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dir_r[i];
                int nc = cur[1] + dir_c[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if(visited[nr][nc] == true || map[nr][nc] == 1) {
                    continue;
                }

                if(map[nr][nc] == 0) {
                    zerochk = true;
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[] {nr,nc});
                cnt++;
            }
        }

        if(zerochk == true) {
            return 0;
        }

        else {
            return cnt;
        }
    }
}