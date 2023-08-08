import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_2467 {
    static int[] waters;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        waters = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            waters[i] = Integer.parseInt(st.nextToken());
        }

        sol();
    }

    static void sol() {
        int gap = Integer.MAX_VALUE;
        int tmp = 0;
        int[] save = new int[2];

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                tmp = Math.abs(waters[i] + waters[j]);

                if(tmp < gap) {
                    gap = tmp;
                    save[0] = waters[i];
                    save[1] = waters[j];
                }
            }
        }

        System.out.println(save[0] + " " + save[1]);
    }
}
