import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// class Knight {
//     int x;
//     int y;
//     int moveCount;

//     public Knight(int x, int y, int moveCount) {
//         this.x = x;
//         this.y = y;
//         this.moveCount = moveCount;
//     }
// }

public class nge_18404 {
    static int n; // 체스판 n x n
    static int[][] map; // 체스판
    static int[] moveY = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] moveX = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // 체스판 크기 및 적의 말의 수
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine()); // 나이트의 좌표
        int kY = Integer.parseInt(st.nextToken());
        int kX = Integer.parseInt(st.nextToken());

        sol(kX,kY);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); // 적 말의 좌표
            int eY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            sb.append(map[eY][eX]).append(" ");
        }

        System.out.println(sb);
    }

    static void sol(int kX, int kY) {
        Queue<int[]> q = new LinkedList<>(); // 큐
        q.add(new int[] {kX, kY});

        while(!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            
            for(int i = 0; i < 8; i++) {
                int ny = y + moveY[i];
                int nx = x + moveX[i];

                if(ny > n || ny < 0 || nx > n || nx < 0) {
                    continue;
                }

                if(map[ny][nx] == 0) {
                    map[ny][nx] = map[y][x] + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}