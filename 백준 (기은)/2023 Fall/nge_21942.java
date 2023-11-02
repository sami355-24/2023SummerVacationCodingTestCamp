import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class nge_21942 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 작성할 정보 개수
        String L = st.nextToken(); // 대여기간
        int F = Integer.parseInt(st.nextToken()); // 벌금

        int ld = Integer.parseInt(L.substring(0, 3));
        int lh = Integer.parseInt(L.substring(4, 6));
        int lm = Integer.parseInt(L.substring(7, L.length()));

        int range = (ld * 24 * 60) + (lh * 60) + lm;

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Long> fin = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String date = st.nextToken();
            String time = st.nextToken();
            String item = st.nextToken();
            String user = st.nextToken();

            String id = item + "_" + user;

            if(map.containsKey(id)) {
                String data1 = map.get(id);
                String data2 = date + " " + time;
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                long d1 = f.parse(data1).getTime();
                long d2 = f.parse(data2).getTime();

                long diff = (d2 - d1) / (1000 * 60);

                if(diff > range) {
                    long gap = diff - range;

                    if(fin.containsKey(user)) {
                        fin.put(user, fin.get(user) + gap * F);
                    }

                    else {
                        fin.put(user, gap * F);
                    }
                }
                map.remove(id);
            }

            else {
                map.put(id, date + " " + time);
            }
        }

        // 출력
        List<String> list = new ArrayList<>(fin.keySet());
        list.sort((s1,s2) -> s1.compareTo(s2));

        if(fin.size() <= 0) {
            System.out.println(-1);
        }

        else {
            StringBuilder sb = new StringBuilder();
            for(String key : list) {
                sb.append(key + " " + fin.get(key) + "\n");
            }
            System.out.print(sb);
        }
	}
}
