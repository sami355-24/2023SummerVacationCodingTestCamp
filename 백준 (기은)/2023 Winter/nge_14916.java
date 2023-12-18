import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_14916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        sol(x);
    }
 
    static void sol(int x) {
        int total;
        int count5 = 0; // 5원의 개수
        int count2 = 0; // 2원의 개수
        
        count5 = x / 5; // 입력 값 x를 5로 나눈다. (5원의 개수의 초기값)
        
        while(true) {
            total = x; // 입력값
            int a = 5 * count5; // 5원 * 현재 5원의 개수
            
            total -= a; // a로 입력값을 제거

            if(total % 2 == 0) { // 남은 입력값이 2로 나누어지는 지 확인
                count2 = total / 2;
                break;
            }

            else {
                if(count5 == 0) { // 5원이 현재 0개인데 2로 안나눠짐
                    System.out.print(-1);
                    return;
                }

                else { // 5원이 아직 남은 경우 5원을 하나씩 제거
                    count5--;
                }
            }
        }

        System.out.print(count5 + count2); // 정답 (5원의 동전개수 + 2원의 동전개수)
    }
}