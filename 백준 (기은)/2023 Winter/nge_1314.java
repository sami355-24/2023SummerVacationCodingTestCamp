import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_1314 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        sol(s);
    }

    static void sol(String s) {
        int p = 0;

        while(true) {
            if(p > s.length() - 1) {
                System.out.print(sb);
                return;
            }

            // .인경우 포인터 한칸 옮겨준다
            if(s.charAt(p) == '.') {
                sb.append('.');
                p++;
                continue;
            }

            // AAAA가 될 수 있는지 확인
            boolean chkA = true;

            if(p + 3 >= s.length()) {
                chkA = false;
            }

            else {
                for(int i = p; i < p + 4; i++) {
                    if(s.charAt(i) != 'X') {
                        chkA = false;
                    }
                }
            
                if(chkA == true) {
                    for(int i = p; i < p + 4; i++) {
                        sb.append('A');
                    }

                    p = p + 4;
                    continue;
                }
            }

            // BB가 될 수 있는지 확인
            boolean chkB = true;

            if(p + 1 >= s.length()) {
                chkB = false;
            }

            else {
                for(int i = p; i < p + 2; i++) {
                    if(s.charAt(i) != 'X') {
                        chkB = false;
                    }
                }

                if(chkB == true) {
                    for(int i = p; i < p + 2; i++) {
                        sb.append('B');
                    }

                    p = p + 2;
                    continue;
                }
            }

            if(!chkA && !chkB) { // AAAA 와 BB 둘 다 안되는 경우
                System.out.print(-1);
                return;
            }
        }
    }
}
