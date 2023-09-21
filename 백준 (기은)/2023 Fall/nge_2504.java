import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class nge_2504 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        sol(exp);
    }

    static void sol(String exp) {
        int ans = 0;
        int mult = 1;

        Stack<Character> s1 = new Stack<>();

        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if(c == '(' || c =='[') {
                s1.push(c);

                if(c == '(') {
                    mult *= 2;
                }

                else {
                    mult *= 3;
                }
            }

            else if(c == ')') {
                if(s1.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                char pre = exp.charAt(i - 1);

                if(pre == '(') {
                    s1.pop();
                    mult /= 2;
                    ans += 2 * mult;
                }

                else {
                    if(s1.peek() == '[') {
                        System.out.println(0);
                        return;
                    }

                    s1.pop();
                    mult /= 2;
                }
            }

            else {
                if(s1.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                char pre = exp.charAt(i - 1);
                if(pre == '[') {
                    s1.pop();
                    mult /= 3;
                    ans += 3 * mult;
                }

                else {
                    if(s1.peek() == '(') {
                        System.out.println(0);
                        return;
                    }

                    s1.pop();
                    mult /= 3;
                }
            }
        }

        if(!s1.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);
    }
}