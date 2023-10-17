import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class nge_7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> maxPQ;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int opCount = Integer.parseInt(br.readLine());
            sol(opCount);
        }

        System.out.print(sb);
    }

    static void sol(int opCount) throws IOException{
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < opCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken(); // 명령어
            int num = Integer.parseInt(st.nextToken()); // 숫자

            if(cmd.charAt(0) == 'I') {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            else {
                if(map.isEmpty()) {
                    continue;
                }

                if(num == - 1) {
                    int key = map.firstKey();
                    int val = map.getOrDefault(key, 0) - 1;

                    if(val <= 0) {
                        map.remove(key);
                    }

                    else {
                        map.put(key, val);
                    }
                }

                else {
                    int key = map.lastKey();
                    int val = map.getOrDefault(key, 0) - 1;

                    if(val <= 0) {
                        map.remove(key);
                    }

                    else {
                        map.put(key, val);
                    }
                }
            }
        }

        if(map.isEmpty()) {
            sb.append("EMPTY\n");
        }

        else {
            sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }
    }
}