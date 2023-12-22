import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nge_1541 {
    static ArrayList<Integer> arr = new ArrayList<>(); // 모든 덧셈을 끝낸뒤의 모든 수의 집합 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        sol(exp);
    }

    static void sol(String exp) {
        StringTokenizer st = new StringTokenizer(exp, "-"); // 먼저 - 를 기준으로 문자열을 자른다

        while(st.hasMoreTokens()) {
            String input = st.nextToken(); // 자른 문자열
            int data = 0; // 자른 문자열를 int 형태로 바꿈

            if(input.contains("+")) { // 자른 문자열이 10+20 과 같은 경우
                ArrayList<Integer> arr2 = new ArrayList<>();

                StringTokenizer st2 = new StringTokenizer(input, "+"); // + 를 기준으로 문자열을 자르고

                // 자른 데이터를 모두 더한다
                while(st2.hasMoreTokens()) {
                    String input2 = st2.nextToken();
                    int x = Integer.parseInt(input2);
                    arr2.add(x);
                }

                for(int e : arr2) {
                    data += e;
                }
            }

            // 자른 문자열이 10 과 같은 단일 데이터인 경우
            else {
                data = Integer.parseInt(input);
            }

            arr.add(data);
        }

        // 각 수의 뺄샘을 계산
        int ans = arr.get(0);

        for(int i = 1; i < arr.size(); i++) {
            ans -= arr.get(i);
        }

        System.out.print(ans);
    }
}