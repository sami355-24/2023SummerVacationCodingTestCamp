import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* 
    ����ǥ���� ���
*/
public class nge_2671{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String noise = "NOISE";
        String submarine = "SUBMARINE";
        // (100~1~|01)~x
        String regexp = "^(100+1+|01)+";
        String str = br.readLine();

        boolean flag = Pattern.matches(regexp, str); // str ���Խİ� ��ġ�ϴ� Ȯ��

        if(flag)
            System.out.println(submarine);
        else
            System.out.println(noise);

    }
}