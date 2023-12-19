import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class nge_1314 {
    static boolean[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        sol(s);
    }

    static void sol(String s) {
        int p = 0;
        ans = new boolean[s.length()];

        while(true) {
            // AAAA가 될 수 있는지 확인
            boolean chk = true;
            for(int i = p; i < p + 4; i++) {
                if(s.charAt(i) != 'X') {
                    chk = false;
                }
            }

            if(chk == true) {
                for(int i = p; i < p + 4; i++) {
                    ans[i] = true;
                }

                p = p + 4;
            }

            // BB가 될 수 있는지 확인
            chk = true;
            for(int i = p; i < p + 2; i++) {
                if(s.charAt(i) != 'X') {
                    chk = false;
                }
            }

            if(chk == true) {
                for(int i = p; i < p + 2; i++) {
                    ans[i] = true;
                }

                p = p + 2;
            }
        }
    }
}
