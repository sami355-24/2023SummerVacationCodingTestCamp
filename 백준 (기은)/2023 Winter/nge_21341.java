import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class nge_21341 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        sol(s);
    }

    static void sol(String s) {
        String min = "";
        String max = "";
        Stack<Character> stack = new Stack<>();
        boolean chk;

        // 최소값 구하기
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'M') {
                stack.push('M');
            }

            else {
                chk = stack.isEmpty();
                
                if(chk == false) {
                    min += "1";
                    stack.pop();

                    while(!stack.isEmpty()) {
                        stack.pop();
                        min += "0";
                    }
                }

                min += "5";
            }
        }

        chk = stack.isEmpty();

        if(chk == false) {
            min += "1";
            stack.pop();

            while(!stack.isEmpty()) {
                stack.pop();
                min += "0";
            }
        }

        // 최대값 구하기
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'M') {
                stack.push('M');
            }

            else {
                max += "5";
                chk = stack.isEmpty();
                
                if(chk == false) {
                    while(!stack.isEmpty()) {
                        stack.pop();
                        max += "0";
                    }
                }
            }
        }

        // stack의 남은 수 추가
        while(!stack.isEmpty()) {
            stack.pop();
            max += "1";
        }

        System.out.println(max);
        System.out.println(min);
    }
}