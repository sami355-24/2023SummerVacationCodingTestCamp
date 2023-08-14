import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    Point() {

    }

    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
}

public class nge_21922 {
    static int[][] matrix;
    static boolean[][] visited;
    static int n;
    static int m;
    static boolean isAirCon;
    static int cntAir = 0;
    static Point[] airPoint;
    static int count = 0;

    // 상하좌우
    static int[] moveX = {0,0,-1,1};
    static int[] moveY = {-1,1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        matrix = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        airPoint = new Point[51];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                if(matrix[i][j] == 9) {
                    isAirCon = true;
                    airPoint[cntAir] = new Point();
                    airPoint[cntAir].y = i;
                    airPoint[cntAir].x = j;
                    cntAir++;
                }
            }
        }

        sol();

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(count + cntAir);
    }

    static void sol() {
        if(isAirCon == false) {
            return;
        }

        for(int j = 0; j < cntAir; j++) {
            for(int i = 1; i <= 4; i++) {
                Point ms = new Point(airPoint[j]);
                move(ms,i);
            }
        }
    }

    static void move(Point ms, int dir) {
        int d = dir;

        while(true) {
            ms.x += moveX[d - 1];
            ms.y += moveY[d - 1];
            
            if(ms.x < 0 || ms.x > m - 1) {
                break;
            }

            if(ms.y < 0 || ms.y > n - 1) {
                break;
            }

            if(visited[ms.y][ms.x] == false) {
                count++;
                visited[ms.y][ms.x] = true;
            }

            if(matrix[ms.y][ms.x] == 1) {
                if(d == 3 || d == 4) {
                    break;
                }
                
            }

            else if(matrix[ms.y][ms.x] == 2) {
                if(d == 1 || d == 2) {
                    break;
                }
              
            }

            else if(matrix[ms.y][ms.x] == 3) {
                if(d == 1) {
                    d = 4;
                }

                else if(d == 2) {
                    d = 3;
                }

                else if(d == 3) {
                    d = 2;
                }

                else {
                    d = 1;
                }
            }

            else if(matrix[ms.y][ms.x] == 4) {
                if(d == 1) {
                    d = 3;
                }

                else if(d == 2) {
                    d = 4;
                }

                else if(d == 3) {
                    d = 1;
                }

                else {
                    d = 2;
                }
            }
        }
    }
}