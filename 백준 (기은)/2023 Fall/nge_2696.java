import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class nge_2696 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine()); // 수열의 크기
            sol(M);
        }

        System.out.print(sb);
    }

    static void sol(int M) throws IOException{
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0; // 중앙값의 개수

        String tmp = "";

        for(int i = 1; i <= M; i++) {
            if((i - 1) % 10 == 0 && i != 1) {
                st = new StringTokenizer(br.readLine());
            }

            int num = Integer.parseInt(st.nextToken()); // 데이터에 해당하는 값을 입력
            
            if(i % 2 != 0) { // 홀수 인덱스의 경우
                count++;

                if(map.getOrDefault(num, null) == null) {
                    map.put(num,1);
                }

                else {
                    int val = map.get(num);
                    map.put(num , val + 1);
                }

                int mid = (i + 1) / 2;

                for(int key : map.keySet()) {
                    mid -= map.get(key);

                    if(mid <= 0) {
                        tmp += Integer.toString(key);
                        tmp += " ";

                        if(count % 10 == 0) {
                            tmp += "\n";
                        }

                        break;
                    }
                }
            }

            else { // 짝수 인덱스의 경우
                if(map.getOrDefault(num, null) == null) {
                    map.put(num,1);
                }

                else {
                    int val = map.get(num);
                    map.put(num , val + 1);
                }
            }
        }

        sb.append(count + "\n");
        sb.append(tmp + "\n");
    }
}