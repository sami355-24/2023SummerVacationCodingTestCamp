import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class nge_1620 {
    static List<String> list = new ArrayList<>(); // 숫자로 찾을 때 사용
    static HashMap<String, Integer> map = new HashMap<>(); // 문자로 찾을 때 사용 key -> value
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pCount = Integer.parseInt(st.nextToken()); // 포켓몬 수
        int qCount = Integer.parseInt(st.nextToken()); // 퀴즈 수

        for(int i = 0; i < pCount; i++) { // 각 리스트와 해쉬맵에 값 입력
            String name = br.readLine();
            list.add(name);
            map.put(name, i + 1);
        }

        for(int i = 0; i < qCount; i++) {
            String q = br.readLine();
            boolean chk = q.matches("[+-]?\\d*(\\.\\d+)?");

            if(!chk) { // 퀴즈가 문자열인 경우
                int ans = map.get(q);
                sb.append(ans + "\n");
            }

            else {
                int src = Integer.parseInt(q);
                String ans = list.get(src - 1);
                sb.append(ans + "\n");
            }
        }

        System.out.println(sb);
    }
}