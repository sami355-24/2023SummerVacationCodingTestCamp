import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class nge_2194 {
    static int[][] GameMap;
    static Point start = new Point();
    static Point end = new Point();
    static boolean[][] visited;

    // 상하좌우
    static int[] moveX = {-1,1,0,0};
    static int[] moveY = {0,0,-1,1};

    // 행렬의 크기
    static int N;
    static int M;

    // 유닛의 크기
    static int A;
    static int B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        GameMap = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        // 장애물 개수
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            GameMap[y][x] = -1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        start.y = Integer.parseInt(st.nextToken());
        start.x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        end.y = Integer.parseInt(st.nextToken());
        end.x = Integer.parseInt(st.nextToken());

        System.out.println(sol());
    }

    static int sol() {
        Queue<Point> q = new LinkedList<Point>();
        q.add(start);
        visited[start.y][start.x] = true;
        int cnt = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Point po = q.poll();
                if(po.x == end.x && po.y == end.y) {
                    return cnt;
                }

                for(int j = 0; j < 4; j++) {
                    int newX = po.x + moveX[j];
                    int newY = po.y + moveY[j];

                    if(!Range(newY, newX)) {
                        continue;
                    }

                    if(!isPossible(newY, newX)) {
                        continue;
                    }

                    q.add(new Point(newX,newY));
                }
            }
            cnt++;
        }

        return -1;
    }

    static boolean Range(int y, int x) {
        if(x >= 1 && x <= M && y >= 1 && y <= N) {
            return true;
        }

        return false;
    }

    static boolean isPossible(int y, int x) {
        if(visited[y][x] == true) {
            return false;
        }

        for(int i = y; i < y + A; i++) {
            for(int j = x;  j < x + B; j++) {
                if(!Range(i,j)) {
                    return false;
                }

                if(GameMap[i][j] == -1) {
                    return false;
                }
            }
        }

        visited[y][x] = true;
        return true;
    }
}