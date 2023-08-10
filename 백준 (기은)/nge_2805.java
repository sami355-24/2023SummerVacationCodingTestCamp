import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_2805 {
    static int n; // 나무의 수
    static int m; // 가져가야하는 나무의 길이
    static int[] trees; // 나무들의 길이 정보
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        sol();
    }

    static boolean ispossible(long length) {
        long taken = 0;

        for(int i = 0; i < n; i++) {
            if(trees[i] >= length) {
                taken += trees[i] - length;
            }
        }

        if(taken >= m) {
            return true;
        }

        else {
            return false;
        }
    }

    static void sol() {
        long start = 0;
        long end = 1000000000;
        long ret = 0;

        while(start <= end) {
            long mid = (start + end) / 2;
            
            if(ispossible(mid)) {
                start = mid + 1;
                ret = mid;
            }
            
            else {
                end = mid - 1;
            }
        }

        System.out.println(ret);
    }
}