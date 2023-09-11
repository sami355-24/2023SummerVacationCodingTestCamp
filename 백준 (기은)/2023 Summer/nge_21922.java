import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nge_21922 {
    final static int fromUp = - 1;
    final static int toDown = - 1;

    final static int fromDown = 1;
    final static int toUp = 1;

    final static int fromLeft = -2;
    final static int toRight = - 2;
    
    final static int fromRight = 2;
    final static int toLeft = 2;
    
    static class Info {
        int row, col, dir;

        public Info(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }
    
    static Queue<Info> q = new LinkedList<>();
    static int[][] map;
    static int n;
    static int m;
    static int count = 0;
    static boolean[][] hasAir;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n + 1][m + 1];
        hasAir = new boolean[n + 1][m + 1];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    q.add(new Info(i - 1, j, toUp));
                    q.add(new Info(i + 1, j, toDown));
                    q.add(new Info(i, j - 1, toLeft));
                    q.add(new Info(i, j + 1, toRight));
                    hasAir[i][j] = true;
                    count++;
                }
            }
        }

        sol();
        System.out.println(count);
    }

    static void sol() {
        while(!q.isEmpty()) {
            Info info = q.poll();
            int row =  info.row;
            int col = info.col;
            int dir = info.dir;

            if(row < 0 || row >= n || col < 0 || col >= m) {
                continue;
            }

            if(!hasAir[row][col]) {
                hasAir[row][col] = true;
                count++;
            }

            switch(map[row][col]) {
                case 0 :
                    if(dir == fromUp)   q.add(new Info(row + 1, col, toDown));
                    if(dir == fromDown) q.add(new Info(row - 1, col, toUp));
                    if(dir == fromLeft) q.add(new Info(row, col + 1, toRight));
                    if(dir == fromRight) q.add(new Info(row, col - 1, toLeft));
                    break;

                case 1 :
                    if(dir == fromUp)   q.add(new Info(row + 1, col, toDown));
                    if(dir == fromDown) q.add(new Info(row - 1, col, toUp));
                    break;

                case 2 :
                    if(dir == fromLeft) q.add(new Info(row, col + 1, toRight));
                    if(dir == fromRight) q.add(new Info(row, col - 1, toLeft));
                    break;

                case 3 :
                    if(dir ==  fromUp) q.add(new Info(row, col - 1, toLeft));
                    if(dir == fromDown) q.add(new Info(row, col + 1, toRight));
                    if(dir == fromRight) q.add(new Info(row + 1, col, toDown));
                    if(dir == fromLeft) q.add(new Info(row - 1, col, toUp));
                    break;

                case 4 : 
                    if(dir == fromUp) q.add(new Info(row, col + 1, toRight));
                    if(dir == fromDown) q.add(new Info(row, col - 1, toLeft));
                    if(dir == fromRight) q.add(new Info(row - 1, col, toUp));
                    if(dir == fromLeft) q.add(new Info(row + 1, col, toDown));
                    break;

                default :
                    break;
            }
        }
    }
}