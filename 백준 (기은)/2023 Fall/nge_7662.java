import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class nge_7662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int opCount = Integer.parseInt(br.readLine());
            sol(opCount);
        }
    }

    static void sol(int opCount) throws IOException{
        TreeMap<Integer, Integer> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < opCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken(); // 명령어
            int num = Integer.parseInt(st.nextToken()); // 숫자

            if(cmd == "I") {
                map.put(num, num);
            }

            else {
                if(map.isEmpty()) {
                    continue;
                }

                if(num == - 1) {
                    map.remove(map.firstKey());
                }

                else {
                    map.remove(map.lastKey());
                }
            }
        }

        if(map.isEmpty()) {
            System.out.println("EMPTY");
            return;
        }

        else {
            StringBuilder sb = new StringBuilder();
            sb.append(map.firstKey() + " ");
            sb.append(map.lastKey());

            System.out.println(sb);
        }
    }
}