import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class nge_11000 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static lecture[] list; // 강의리스트
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new lecture[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); // 강의 시작
            int t = Integer.parseInt(st.nextToken()); // 강의 종료

            list[i] = new lecture(s, t);
        }

        // list 정렬 (시작시간으로 기준으로 오름차순 정렬 만약 시간시간이 같다면 종료시간 기준으로 정렬)
        Arrays.sort(list, new Comparator<lecture>() {
            public int compare(lecture l1, lecture l2) {
                if(l1.start == l2.start) {
                    return l1.end - l2.end;
                }

                else {
                    return l1.start - l2.start;
                }
            }
        });

        sol();
    }

    static void sol() {
        pq.offer(list[0].end);

        // 가장 작은 종료시간과 현재 list에서의 시작시간을 비굔
        for(int i = 1; i < N; i++) {
            if(pq.peek() <= list[i].start) {
                pq.poll();
            }

            pq.offer(list[i].end);
        }

        System.out.print(pq.size());
    }

    // 강의 클래스
    static class lecture {
        int start;
        int end;

        public lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
