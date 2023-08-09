import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_21921 {
    static int n;
    static int x;
    static int[] visitors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visitors = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        sol();
    }

    static void sol() {
        int left = 0;
        int right = x - 1;
        int max;
        int max_count; // 최대치가 나온 갯수
        int sum = 0;

        for(int i = left; i <= right; i++) {
            sum += visitors[i];
        }
        max = sum;
        max_count = 1;

        while(right < n - 1) {

            int pre_left = left;

            right++;
            left++;

            sum += visitors[right];
            sum -= visitors[pre_left];

            if(max < sum) {
                max = sum;
                max_count = 1;
            }

            else if(max == sum) {
                max_count++;
            }
        }
        
        if(max == 0) {
           System.out.println("SAD");
        }

        else {
           System.out.println(max);
           System.out.println(max_count);
        }
    }
}