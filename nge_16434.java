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
    long maxHp = 0;
    long curHp = 0;
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
        // 입력

        Hero hero = new Hero(ATK);

        for(int i = 0; i < N; i++) {
            if(room[i].id == 1) {
                long defenceCount = (room[i].hp / hero.atk) - (room[i].hp % hero.atk != 0 ? 0 : 1);
                hero.curHp += defenceCount * room[i].atk;
                hero.maxHp = Math.max(hero.maxHp, hero.curHp);
            }

            else {
                hero.atk += room[i].atk;
                hero.curHp = Math.max(hero.curHp - room[i].hp, 0);
            }
        }

        System.out.println(hero.maxHp + 1);
    }
}