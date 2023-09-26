import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class nge_2493 {
    static Stack<int[]> s = new Stack<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int towerCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= towerCount; i++) {
            int height = Integer.parseInt(st.nextToken());

            if(s.isEmpty()) { // 현재 stack이 비어있는 경우
                sb.append("0 ");
            }

            else { // 비어 있지 않은 경우
                while(s.peek()[1] < height) { // 송신탑의 높이가 top의 높이와 같아지는 값이 있다면 찾는다.
                    s.pop();

                    if(s.isEmpty()) { // 없는 경우 break
                        break;
                    }
                }

                if(s.isEmpty()) { // 0을 추가
                    sb.append("0 ");
                }

                else { // top의 높이를 추가
                    sb.append(s.peek()[0] + " ");
                }
            }

            s.push(new int[] {i, height}); // 0 : 인텍스, 1 : 높이 -> 송신탑의 정보를 스택 안에 추가
        }

        System.out.println(sb);
    }
}