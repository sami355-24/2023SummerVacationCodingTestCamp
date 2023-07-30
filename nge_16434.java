import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Room {
    int id;
    long atk;
    long hp;

    public Room(int id, long atk, long hp) {
        this.id = id;
        this.atk = atk;
        this.hp = hp;
    }
}

class Hero {
    long atk;

    public Hero(long atk) {
        this.atk = atk;
    }
}

public class nge_16434 {
    public static void main(String[] args) throws IOException {
        int N; // 방의 개수
        int ATK; // 용사의 공격력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        ATK = Integer.parseInt(st.nextToken());
        Room[] room = new Room[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int id = Integer.parseInt(st.nextToken());
            long atk = Long.parseLong(st.nextToken());
            long hp = Long.parseLong(st.nextToken());

            room[i] = new Room(id,atk,hp);
        }

        long[] damageCount = new long[N];
        
        for(int i = 0; i < N; i++) {
            damageCount[i] = 0;
        }

        Hero hero = new Hero(ATK);

        for(int i = 0; i < N; i++) {

            if(room[i].id == 1) {
                long hitCount = room[i].hp / hero.atk;
                
                if(room[i].hp % hero.atk != 0) {
                    hitCount += 1;
                }

                long defenceCount = hitCount - 1;

                damageCount[i] = defenceCount * room[i].atk;
            }

            else {
                hero.atk += room[i].atk;
                damageCount[i] -= (room[i].hp);
            }
        }

        System.out.println(sol(damageCount, N));
    }

    static long sol(long[] damageCount, int N) {
        long ans = 0;

        for(int i = 0; i < N; i++) {
            ans += damageCount[i];
        }

        // for(int i = 0; i < N; i++) {
        //     if(ans < damageCount[i]) {
        //         ans = damageCount[i];
        //     }
        // }

        return ans + 1;
    }
}