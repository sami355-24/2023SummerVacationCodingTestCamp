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

    static int sol(String s, String T) {
        return 1;
    }
}
