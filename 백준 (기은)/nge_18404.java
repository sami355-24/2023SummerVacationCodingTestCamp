import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Knight {
    int x;
    int y;
    int moveCount;

    public Knight(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }
}

public class nge_18404 {
    static int n; // 체스판 n x n
    static int m; // 적의 말의 수
    static int[][] map; // 체스판
    static int[] moveY = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] moveX = {-1, 1, -2, 2, -2, 2, -1, 1};
    static Knight knight;

    // 초기 나이트 좌표
    static int kX;
    static int kY;

    static boolean[][] visited; // 방문 여부
    static Queue<Knight> q = new LinkedList<>(); // 큐
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        st = new StringTokenizer(br.readLine()); // 나이트의 좌표
        kY = Integer.parseInt(st.nextToken());
        kX = Integer.parseInt(st.nextToken());
        knight = new Knight(kX, kY, 0);
        q.add(knight);

        sol();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); // 적 말의 좌표
            int eY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            sb.append(map[eY][eX]).append(" ");
        }

        System.out.println(sb);
    }

    static void sol() {

        while(!q.isEmpty()) {   
            knight = q.poll();
            kY = knight.y;
            kX = knight.x;
            int kMC = knight.moveCount;
            visited[kY][kX] = true;    
            map[kY][kX] = kMC;
            
            for(int i = 0; i < 8; i++) {
                kY = knight.y + moveY[i];
                kX = knight.x + moveX[i];

                if(kY > n || kY < 0 || kX > n || kX < 0) {
                    continue;
                }

                if(visited[kY][kX] == false) {
                    q.add(new Knight(kX, kY, kMC + 1));
                }
            }
        }
    }
}