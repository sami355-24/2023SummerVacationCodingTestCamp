import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2630 {

    public static void main(String[] args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];

        for(int i = 0; i < n; i++) { // ют╥б
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(br.readLine());      
            }
        }
    }

    static void sol() {
        // ...
    }
}