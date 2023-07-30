import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_2630 {
    static int[][] arr;
    static int white = 0; // 흰색 색종이 개수
    static int blue = 0; // 파란색 색종이 개수

    public static void main(String[] args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 한 변의 길이

        arr = new int[n + 1][n + 1];

        StringTokenizer st;

        for(int i = 1; i <= n; i++) { // 입력값 삽입
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());    
            }
        }

        sol(1, 1, n);

        System.out.println(white);
        System.out.println(blue);
    }
    
    static void sol(int x , int y, int size) {

        if(checkColor(x,y,size) == true) {
            if(arr[x][y] == 0) {
                white++;
            }

            else {
                blue++;
            }

            return;
        }

        int halfSize = size / 2;

        sol(x, y, halfSize);
        sol(x , y + halfSize, halfSize);
        sol(x + halfSize, y, halfSize);
        sol(x + halfSize, y + halfSize, halfSize);
    }

    static Boolean checkColor(int x, int y, int size) { // 영역안에 다른 색깔이 있는 지 확인.
        int init = arr[x][y]; // 초기값 설정
        
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(arr[i][j] != init) {
                    return false;
                }
            }
        }

        return true;
    }
}