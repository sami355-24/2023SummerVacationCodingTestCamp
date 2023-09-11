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
        int left = 0;
        int right = n - 1;
        int ml = 0;
        int mr = 0;
        long min = Long.MAX_VALUE;

        while(left < right) {
            long sum = waters[left] + waters[right];
            long gap = Math.abs(sum);

            if(sum == 0) {
                ml = waters[left];
                mr = waters[right];
            }

            if(min > gap) {
                min = gap;
                ml = waters[left];
                mr = waters[right];
            }

            if(sum > 0) {
                right--;
            }

            else {
                left++;
            }
        }

        System.out.println(ml + " " + mr);
    }
}
