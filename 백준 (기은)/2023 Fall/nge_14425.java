import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class nge_14425 {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> S = new HashMap<>(); // 집합 S
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0; // M개의 문자열 중에서 집합 S에 포함된 문자열의 개수

        int N = Integer.parseInt(st.nextToken()); // S안에 포함된 문자열의 개수
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) { // 집합 S에 입력
            String s = br.readLine();
            S.put(s,i);
        }

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(S.get(s) != null) {
                count++;
            }
        }

        System.out.println(count);
    }
}