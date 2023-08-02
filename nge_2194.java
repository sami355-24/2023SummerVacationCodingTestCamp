import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Game {
    int[][] gameMap;
    Unit unit;

    public void init(int N, int M) {
        gameMap = new int[N + 1][M + 1];
    }

    public void setObstacle(int x, int y) {
        gameMap[x][y] = 2;
    }

    public void setStartEndPoint(int sx, int sy, int ex, int ey) {
        gameMap[sx][sy] = 1;
        gameMap[ex][ey] = 3;
    }

    public void setunit(int x, int y) {
        unit.x = x;
        unit.y = y;
    }
}

class Unit {
    int x;
    int y;
    int move_count = 0;
    
    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class nge_2194 {
    static Game game = new Game();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 행렬의 크기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        game.init(N,M);

        // 유닛의 크기
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        // 장애물 갯수
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            game.setObstacle(x,y);
        }

        
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        game.setStartEndPoint(sx, sy, ex, ey);
        
        sol(A,B);
    }

    static void sol(int A, int B) {
        Stack s = new Stack<Pair>();
        // 상하좌우로 움직이기 상(-1,0) 하(+1,0) 좌(0,-1), 우(0,+1)
        if()
        s.push(s);
    }
}