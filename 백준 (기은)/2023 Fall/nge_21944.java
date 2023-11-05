import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class nge_21944 {
    static int[] realData = new int[100001]; // data[문제번호] = 난이도 데이터 유/무 체크

    // 난이도 별 데이터 저장
    static TreeSet<Problem> data = new TreeSet<>(); // 키 : 문제번호, 값 : 문제
    
    // 키 : 알고리즘 그룹, 값 : 각 문제번호의 우선 순위 큐 (그룹별 데이터)
    static HashMap<Integer, PriorityQueue<Problem>> maxMap = new HashMap<>(); // 최대 큐
    static HashMap<Integer, PriorityQueue<Problem>> minMap = new HashMap<>(); // 최소 큐

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{        
        int N = Integer.parseInt(br.readLine()); // 문제 리스트 안의 문제 개수

        for(int i = 0; i < N; i++) { // 문제 리스트 정보 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()); // 문제번호
            int L = Integer.parseInt(st.nextToken()); // 난이도
            int G = Integer.parseInt(st.nextToken()); // 그룹

            realData[idx] = L;
            data.add(new Problem(idx, L));
            
            if(maxMap.containsKey(G)) {
                PriorityQueue<Problem> tmp1 = maxMap.get(G);
                PriorityQueue<Problem> tmp2 = minMap.get(G);
                tmp1.add(new Problem(idx, L));
                tmp2.add(new Problem(idx, L));
                maxMap.put(G,tmp1);
                minMap.put(G,tmp2);
            }

            else {
                PriorityQueue<Problem> tmp1 = new PriorityQueue<>(Collections.reverseOrder());
                PriorityQueue<Problem> tmp2 = new PriorityQueue<>();
                tmp1.add(new Problem(idx, L));
                tmp2.add(new Problem(idx, L));
                maxMap.put(G,tmp1);
                minMap.put(G,tmp2);
            }

        }

        int cmdCount = Integer.parseInt(br.readLine());

        // 명령어 입력
        for(int i = 0; i < cmdCount; i++) {
            String s = br.readLine();
            cmdExe(s);
        }

        System.out.println(sb);
    }

    static void cmdExe(String s) { // 명령어 실행 함수
        StringTokenizer st = new StringTokenizer(s);
        String cmd = st.nextToken();

        int idx; // 문제번호
        int L; // 난이도
        int G; // 그룹
        int x; // 1 || -1

        switch (cmd) {
            case "add" : // 데이터 추가
                idx = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                G = Integer.parseInt(st.nextToken());
                
                realData[idx] = L;
                data.add(new Problem(idx, L));

                if(maxMap.containsKey(G)) {
                    PriorityQueue<Problem> tmp1 = maxMap.get(G);
                    PriorityQueue<Problem> tmp2 = minMap.get(G);
                    tmp1.add(new Problem(idx, L));
                    tmp2.add(new Problem(idx, L));
                    maxMap.put(G,tmp1);
                    minMap.put(G,tmp2);
                }

                else {
                    PriorityQueue<Problem> tmp1 = new PriorityQueue<>(Collections.reverseOrder());
                    PriorityQueue<Problem> tmp2 = new PriorityQueue<>();
                    tmp1.add(new Problem(idx, L));
                    tmp2.add(new Problem(idx, L));
                    maxMap.put(G,tmp1);
                    minMap.put(G,tmp2);
                }

                break;

            case "solved" : // 문제해결
                idx = Integer.parseInt(st.nextToken());
                realData[idx] = 0;
                break;

            case "recommend" : 
                G = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    PriorityQueue<Problem> tmp = maxMap.get(G);
        
                    while(true) {
                        Problem p = tmp.peek();
                        if(realData[p.idx] == p.L) {
                            sb.append(p.idx).append("\n");
                            break;
                        }

                        tmp.poll(); // 필요없는 데이터 삭제
                    }

                    maxMap.put(G, tmp);
                }

                else {
                    PriorityQueue<Problem> tmp = minMap.get(G);

                    while(true) {
                        Problem p = tmp.peek();
                        if(realData[p.idx] == p.L) {
                            sb.append(p.idx).append("\n");
                            break;
                        }

                        tmp.poll(); // 필요없는 데이터 삭제
                    }

                    minMap.put(G, tmp);
                }

                break;

            case "recommend2" :
                x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    while(true) {
                        Problem p = data.last();

                        if(realData[p.idx] == p.L) {
                            sb.append(p.idx).append("\n");
                            break;
                        }

                        data.pollLast();
                    }
                }

                else {
                    while(true) {
                        Problem p = data.first();

                        if(realData[p.idx] == p.L) {
                            sb.append(p.idx).append("\n");
                            break;
                        }

                        data.pollFirst();
                    }
                }

                break;

            default:
                x = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    int chk = 0;
                    for(Problem p : data) {
                        if(data.size() <= 0) {
                            sb.append(-1).append("\n");
                            break;
                        }

                        if(realData[p.idx] != p.L) {
                            data.remove(p);
                            continue;
                        }

                        if(p.L >= L) {
                            sb.append(p.idx).append("\n");
                            chk = 1;
                            break;
                        }
                    }

                    if(chk == 0) {
                        sb.append(-1).append("\n");
                    }
                }

                else {
                    int chk = 0;
                     for(Problem p : data.descendingSet()) {

                        if(realData[p.idx] != p.L) {
                            data.remove(p);
                            continue;
                        }

                        if(p.L < L) { // L보다 작은거 중에 문제번호가 가장 큰 것
                            sb.append(p.idx).append("\n");
                            chk = 1;
                            break;
                        }
                    }

                    if(chk == 0) {
                        sb.append(-1).append("\n");
                    }
                }

                break;
        }
    }

    static class Problem implements Comparable<Problem>{ // 문제
        int idx; // 번호
        int L; // 난이도
        
        public Problem(int idx, int L) {
            this.idx = idx;
            this.L = L;
        }

        // 정렬기준은 1. 난이도 2. 문제번호 순으로 정렬 (오름차순)
        @Override
        public int compareTo(Problem p1) { // 오름차순
            if(this.L == p1.L) {
                return Integer.compare(this.idx, p1.idx);
            }

            return Integer.compare(this.L, p1.L);
        }
    }
}