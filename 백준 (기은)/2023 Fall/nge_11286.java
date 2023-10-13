import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class nge_11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>( // 우선순위 큐 우선순위 재정의
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) { // 절대값 기준으로 오름차순 비교
                    int x = Math.abs(o1);
                    int y = Math.abs(o2);

                    if(x == y) {
                        return o1 > o2 ? 1 : - 1;
                    }

                    return x > y ? 1 : -1;
                }
            }
        );

        int N = Integer.parseInt(br.readLine()); // 연산개수

        StringBuilder sb = new StringBuilder(); // 출력할 StringBuilder
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) { // 입력값이 0인경우
                if(pq.isEmpty()) {
                    sb.append(0 + "\n");
                }

                else {
                    sb.append(pq.poll() + "\n");
                }
            }

            else { // 입력값이 0이 아닌 경우
                pq.add(input);
            }
        }

        System.out.print(sb);
    }
}