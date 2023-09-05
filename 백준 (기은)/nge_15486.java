import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Value implements Comparable<Value>{
    int day; // 상담날짜
    int t; // 상담완료시 걸리는 시간
    int val;
    int p;

    public int compareTo(Value v) {
        if()
    }
}

public class nge_15486 {
    static int[] t;
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        sol(n);
    }

    /*
    솔루션
     * 1. 가성비가 큰 것을 기준으로 고른다.
     * 2. 고른 상담에 대하여 되는지 여부를 확인한다.
     * 3. 된다면 이것을 고르고 이 날짜의 상담을 골랐을때 안되는 상담일자를 제거
     */
    static void sol(int n) {
        int total = 0;
        Value[] value = new Value[n]; // 가성비
        boolean[] chk = new boolean[n + 1]; // 일정 체크

        for(int i = 0; i < n; i++) { // 각 상담에 대한 가성비 입력
            value[i] = new Value();
            value[i].day = i + 1;
            value[i].val = p[i] * 2 / t[i];
            value[i].t = t[i];
            value[i].p = p[i];
        }

        Arrays.sort(value);
        
        for(int i = 0; i < n; i++) {
            boolean isCon = false;
            
            for(int j = 0; j < value[i].t; j++) {
                int res = value[i].day + j;

                if(res > n) {
                    isCon = true;
                    break;
                }

                else if(chk[res] == true) {
                    isCon = true;
                    break;
                }
            }

            if(isCon == false) {
                // System.out.println(value[i].day);
                total += value[i].p;
                for(int j = 0; j < value[i].t; j++) {
                    chk[value[i].day + j] = true;
                }
            }
        }
        

        System.out.println(total);
    }
}
