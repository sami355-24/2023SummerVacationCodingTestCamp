import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class nge_10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        sol(s);
    }

    static void sol(String s) {
        Stack<Character> stack = new Stack<>();
        int ret = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') { // 열린괄호의 경우
                stack.push(c);
                continue;
            }

            else { // 닫힌괄호의 경우
                stack.pop();
                char pre = s.charAt(i - 1); // 이전 값

                if(pre == '(') { // 레이저인 경우 
                    ret += stack.size(); // stack에 있는 값 만큼 더함.
                }

                else { // 레이저가 아닌 경우
                    ret += 1; // + 1 한다.
                }
            }
        }

        System.out.println(ret);
    }
}