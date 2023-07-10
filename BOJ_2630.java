import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2630 {
    static int count[] = {0,0};
    public static void main(String[] args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 배열 정보

        int[][] arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) { // 입력
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }

        sol(n, n, arr);
    }
    
    static void sol(int x , int y, int[][] arr) {
        // x의 절편, y의 절편을 알 수 있음.
        // 중간점
        int mid_x = x / 2;
        int mid_y = y / 2;

        int[] chk = {0,0,0,0}; // 4개의 부분 (모두 1인 경우 1, 모두 0인 경우 0, 그게 아닌 경우 2)

        int init = arr[mid_x][mid_y];

        for(int i = 1; i <= mid_x; i++) {
            for(int j = 1; j <= mid_y; j++) {
                if(arr[i][j] != init) {
                    chk[0] = 2;
                }        
            }
        }

        if(chk[0] != 2) {
            count[init] += 1;
        }

        else {
            
        }

        init = arr[mid_x][mid_y + 1];

        for(int i = 1; i <= mid_x; i++) {
            for(int j = mid_y + 1; j <= y; j++) {
                if(arr[i][j] != init) {
                    chk[1] = 2;
                }        
            }
        }

        if(chk[1] != 2) {
            count[init] += 1;
        }

        init = arr[mid_x + 1][mid_y];

        for(int i = mid_x + 1; i <= x; i++) {
            for(int j = 1; j <= mid_y; j++) {
                if(arr[i][j] != init) {
                    chk[2] = 2;
                }
            }
        }
        
        if(chk[2] != 2) {
            count[init] += 1;
        }

        init = arr[mid_x + 1][mid_y + 1];

        for(int i = mid_x + 1; i <= x; i++) {
            for(int j = mid_y + 1; j <= y; j++) {
                if(arr[i][j] != init) {
                    chk[3] = 2;
                }
            }
        }

        if(chk[3] != 2) {
            count[init] += 1;
        }
    }
}