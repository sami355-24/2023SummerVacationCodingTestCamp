import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_16953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 1;
        boolean chk = false;

        while(A <= B) {
            if(A == B) {
                chk = true;
                break;
            }

            if(B % 2 == 0) {
                B = B / 2;
                count++;
            }

            else if(B % 10 == 1) {
                B = B / 10;
                count++;
            }

            else {
                break;
            }
        }

        if(!chk) {
            System.out.print(-1);
            return;
        }

        System.out.print(count);
    }
}