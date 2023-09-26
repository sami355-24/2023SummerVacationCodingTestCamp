import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;
import java.util.List;

public class nge_2800 {
    static List<int[]> list = new ArrayList<>();
    static TreeSet<String> t = new TreeSet<>();
    static boolean[] chk;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        chk = new boolean[exp.length()];
        sol(exp);

        for(String s : t) {
            System.out.println(s);
        }
    }

    static void sol(String exp) {
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if(c == '(') {
                s.push(i); // 열린 괄호 위치 스택에 저장
            }

            else if(c == ')') {
                list.add(new int[] {s.pop(), i}); // 각 열린 괄호 위치와 닫힌 괄호 위치를 저장 
            }
        }

        comb(0,exp);
    }

    static void comb(int depth, String exp) { // 조합 함수
        if(depth == list.size()) {
            StringBuilder sb = new StringBuilder();
            Boolean f = false; // chk에서 아무 것도 안 없어진 경우는 제외

            for(int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);

                if(!chk[i]) {
                    sb.append(c);
                }

                else {
                    f = true;
                }
            }

            if(f == true) {
                t.add(sb.toString());
            }

            return;
        }

        comb(depth + 1, exp);

        int[] tmp = list.get(depth);
        chk[tmp[0]] = true;
        chk[tmp[1]] = true;

        comb(depth + 1, exp);

        chk[tmp[0]] = false;
        chk[tmp[1]] = false;
    }
}