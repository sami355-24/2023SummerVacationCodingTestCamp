import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int Qcount = Integer.parseInt(br.readLine());

        StringTokenizer st;

        char at;
        int start;
        int end;

        for(int i = 0; i < Qcount; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input, " ");
            at = st.nextToken().charAt(0);
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            String t = s.substring(start, end + 1);
            System.out.println(sol(t,at));
        }
    }

    static int sol(String t, char at) {
        int count = 0;

        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == at) {
                count++;
            }
        }

        return count;
    }
}