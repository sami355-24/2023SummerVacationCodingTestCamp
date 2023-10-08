import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_22942 {
    static List<int[]> list = new ArrayList<>(); // 원의 정보를 담은 리스트 (0 : 원의 중심 1 : 반지름)
    static int[] max = {0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 원의 개수

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] input = new int[2];
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            
            if(max[1] < input[1]) { // 가장 큰 원 구하기
                max = input;
            }

            list.add(input);
        }

        sol(); // 솔루션
    }

    static void sol() {
        boolean chk = false; // 동접원인지 체크
        boolean ans = true; // 출력 값

        // 풀이
        for(int[] info : list) {
            int d = Math.abs(max[0] - info[0]); // d 구하기
            int sum = max[1] + info[1]; // rA + rB
            int diff = Math.abs(max[1] - info[1]); // rA - rB 의 절대값

            if(d == 0) {
                if(chk == false) {
                    chk = true;
                    continue;
                }

                else {
                    ans = false;
                    break;
                }
            }

            else if(sum == d) {
                ans = false;
                break;
            }

            else if(diff == d) {
                ans = false;
                break;
            }

            else if(d > diff && d < sum) {
                ans = false;
                break;
            }
        }

        System.out.println(ans ? "YES" : "NO");
    }
}