import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_2302 {
    static boolean[] selected;
    static boolean[] chs;
    static int count = 0;
    static int n;
    static int[] saveFix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 좌석의 개수
        int m = Integer.parseInt(br.readLine()); // 고정석의 개수

        selected = new boolean[n + 1];
        chs = new boolean[n + 1];
        saveFix = new int[m];
        chs[0] = true;

        for(int i = 0; i < m; i++) {
            int fix = Integer.parseInt(br.readLine());
            saveFix[i] = fix;
            selected[fix] = true;
        } // 고정석 추가

        sol(1);

        System.out.println(count);
    }

    static void init() {
        selected = new boolean[n + 1];
        chs[0] = true;

        for(int i : saveFix) {
            selected[i] = true;
        }
    }

    static void sol(int loc) {
        if(loc == n) {
            count++;
            return;
        }

        if(selected[loc] == true) { // 지정석
            chs[loc] = true;
            sol(loc + 1);
            chs[loc] = false;
        }

        else { // 지정석이 아닌 경우
           if(!selected[loc - 1] && !chs[loc - 1]) {
                chs[loc - 1] = true;
                sol(loc + 1);
                chs[loc - 1] = false;
           }

           if(!selected[loc + 1] && !chs[loc + 1]) {
                chs[loc + 1] = true;
                sol(loc + 1);
                chs[loc + 1] = false;
           }

            chs[loc] = true;
            sol(loc + 1);
            chs[loc] = false;
        }
    }
}