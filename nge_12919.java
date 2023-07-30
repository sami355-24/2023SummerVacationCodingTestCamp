import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_12919 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 문자열 S
        String T = br.readLine(); // 문자열 T

        int canChange = sol(S,T);

        System.out.println(canChange);
    }

    static int sol(String S, String T) {
        if(S.length() == T.length()) {
            if(S.equals(T) == true) {
                return 1;
            }

            else {
                return 0;
            }
        }

        int ret = 0;
        StringBuilder sb;

        if(T.charAt(0) == 'B') { // B인경우 역방향으로 돌려서 자르기
            sb = new StringBuilder(T.substring(1));
            String temp = sb.reverse().toString();
            ret += sol(S,temp);    
        }

        if(T.charAt(T.length() - 1) == 'A') { // A의 경우 가장 뒤에꺼만 남겨두고 자르기
            sb = new StringBuilder(T.substring(0,T.length() - 1));
            String temp = sb.toString();
            ret += sol(S,temp);
        }

        return ret > 0 ? 1 : 0;
    }
}
