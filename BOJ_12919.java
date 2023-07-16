import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 문자열 S
        String T = br.readLine(); // 문자열 T

        int canChange = sol(S,T);

        System.out.println(canChange);
    }

    static int sol(String S, String T) {
        StringBuffer sb = new StringBuffer(S);
        String reverse_S = sb.reverse().toString();

        if(!(T.contains(S) || T.contains(reverse_S))) {
            return 0;
        }

        if(T.charAt(0) == 'A' && T.contains("B")) {
            return 0;
        }

        return 1;
    }
}
