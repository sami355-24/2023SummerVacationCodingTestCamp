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
                    int val = (int)Math.pow(10, stack.size() - 1);
                    min += Integer.toString(val);
                    stack = new Stack<>();
                }

                min += "5";
            }
        }

        chk = stack.isEmpty();

        if(chk == false) {
            int val_s = (int)Math.pow(10, stack.size() - 1);
            min += Integer.toString(val_s);
            stack = new Stack<>();
        }

        // 최대값 구하기
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'M') {
                stack.push('M');
            }

            else {
                chk = stack.isEmpty();
                int val = 5;

                if(chk == false) {
                    val = 5 * (int)Math.pow(10, stack.size());
                    stack = new Stack<>();
                }

                max += Integer.toString(val);
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
