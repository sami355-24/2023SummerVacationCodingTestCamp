import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_10844 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine()); // �Է�
        
        long[][] d = new long[input + 1][10];
        long mod = 1000000000;

        // �ʱ�ȭ
        d[1][0] = 0;
        for(int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for(int i = 2; i <= input; i++) {

            for(int j = 0; j <= 9; j++) {

                if(j == 0) {
                    d[i][0] = d[i - 1][1] % mod;
                }

                else if(j == 9) {
                    d[i][9] = d[i - 1][8] % mod;
                }

                else {
                    d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod; 
                }

            }
        }

        long sum = 0;

        for(int i = 0; i <= 9; i++) {
            sum += d[input][i];
        }

        System.out.print(sum % mod);
    }
}