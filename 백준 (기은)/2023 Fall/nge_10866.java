import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedDeque;

public class nge_10866 {
    static Deque<Integer> d = new ConcurrentLinkedDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int input = 0;

            if(s.contains("push")) {
                input = Integer.parseInt(st.nextToken());
            }

            sol(s,input);
        }

        System.out.print(sb);
    }

    static void sol(String s, int input) {
        switch (s) {
            case "push_front":
                d.addFirst(input);
                break;
            
            case "push_back":
                d.addLast(input);
                break;

            case "pop_front":
                if(d.size() == 0) {
                    sb.append(-1 + "\n");
                    break;
                }

                sb.append(d.getFirst() + "\n");
                d.removeFirst();
                break;

            case "pop_back":
                if(d.size() == 0) {
                    sb.append(-1 + "\n");
                    break;
                }

                sb.append(d.getLast() + "\n");
                d.removeLast();
                break;

            case "size":
                sb.append(d.size() + "\n");
                break;

            case "empty":
                if(d.size() == 0) {
                    sb.append(1 + "\n");
                    break;
                }
                sb.append(0 + "\n");
                break;

            case "front":
                if(d.size() == 0) {
                    sb.append(-1 + "\n");
                    break;
                }

                sb.append(d.getFirst() + "\n");
                break;
            
            case "back":
                if(d.size() == 0) {
                    sb.append(-1 + "\n");
                    break;
                }

                sb.append(d.getLast() + "\n");
                break;

            default:
                break;
        }
    }
}

