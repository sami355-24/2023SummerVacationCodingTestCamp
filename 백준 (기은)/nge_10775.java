import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_10775 {
    static int[] parent; // 차선책
    static int[] plane; // 비행기 배열
    
    public static void main(String[] args) throws IOException {
        int g; // 게이트의 수
        int p; // 비행기의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine()); 
        plane = new int[p];
        parent = new int[g + 1];

        for(int i = 0; i < p; i++) {
            plane[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        sol(g,p);
    }

    static void sol(int g, int p) {
        int count = 0;

        for(int i = 0; i < p; i++) {
            int cur = plane[i];
            int index = find(cur);

            if(index == 0) {
                break;
            }

            set(index, index - 1);
            count++;
        }

        System.out.println(count);
    }

    static int find(int g) {
        if(g == parent[g]) {
            return g;
        }

        return parent[g] = find(parent[g]);
    }

    static void set(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }
    }
}