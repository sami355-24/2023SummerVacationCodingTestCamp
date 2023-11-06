import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class nge_21944 {
    static TreeSet<Problem> data = new TreeSet<>(); // 전체 데이터
    static HashMap<Integer, TreeSet<Problem>> GroupMap = new HashMap<>(); // 그룹 별로 구분된 맵
    static HashMap<Integer, Integer> levelMap = new HashMap<>(); // 문제별 난이도
    static HashMap<Integer, Integer> algoMap = new HashMap<>(); // 문제별 그룹

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{        
        int N = Integer.parseInt(br.readLine()); // 문제 리스트 안의 문제 개수

        for(int i = 0; i < N; i++) { // 문제 리스트 정보 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()); // 문제번호
            int L = Integer.parseInt(st.nextToken()); // 난이도
            int G = Integer.parseInt(st.nextToken()); // 그룹

            data.add(new Problem(idx, L, G)); // 전체 데이터

            // 그룹 데이터
            if(GroupMap.containsKey(G)) {
                TreeSet<Problem> tmp = GroupMap.get(G);
                tmp.add(new Problem(idx, L, G));
                GroupMap.put(G, tmp);
            }

            else {
                TreeSet<Problem> tmp = new TreeSet<>();
                tmp.add(new Problem(idx, L, G));
                GroupMap.put(G, tmp);
            }

            // 나머지
            levelMap.put(idx, L);
            algoMap.put(idx, G);
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
            case "add" :
                idx = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                G = Integer.parseInt(st.nextToken());
                data.add(new Problem(idx, L, G)); // 전체 저장소에 추가

                // 그룹 저장소에 추가
                if(GroupMap.containsKey(G)) {
                    TreeSet<Problem> tmp = GroupMap.get(G);
                    tmp.add(new Problem(idx, L, G));
                    GroupMap.put(G, tmp);
                }

                else {
                    TreeSet<Problem> tmp = new TreeSet<>();
                    tmp.add(new Problem(idx, L, G));
                    GroupMap.put(G, tmp);
                }

                // 나머지 저장소에 추가
                levelMap.put(idx, L);
                algoMap.put(idx, G);
                
                break;

            case "solved" :
                idx = Integer.parseInt(st.nextToken());
                G = algoMap.get(idx);
                L = levelMap.get(idx);

                // 모든 저장소에서 삭제
                data.remove(new Problem(idx, L, G));
                GroupMap.get(G).remove(new Problem(idx, L, G));
                levelMap.remove(idx);
                algoMap.remove(idx);

                break;

            case "recommend" : 
                G = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    TreeSet<Problem> tmp = GroupMap.get(G);
                    sb.append(tmp.last().idx).append("\n");
                }

                else {
                    TreeSet<Problem> tmp = GroupMap.get(G);
                    sb.append(tmp.first().idx).append("\n");
                }

                break;

            case "recommend2" :
                x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    sb.append(data.last().idx).append("\n");
                }
                
                else {
                    sb.append(data.first().idx).append("\n");
                }

                break;
            
            default:
                x = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    if(data.ceiling(new Problem(0, L, 0)) == null) {
                        sb.append(-1).append("\n");
                    }
                    
                    else {
                        sb.append(data.ceiling(new Problem(0, L, 0)).idx).append("\n");
                    }
                }
                
                else {
                    if(data.floor(new Problem(0, L, 0)) == null) {
                        sb.append(-1).append("\n");
                    }

                    else {
                        sb.append(data.floor(new Problem(0, L, 0)).idx).append("\n");
                    }
                }

                break;
        }
    }

    static class Problem implements Comparable<Problem>{ // 문제
        int idx; // 번호
        int G; // 그룹
        int L; // 난이도
        
        public Problem(int idx, int L ,int G) {
            this.idx = idx;
            this.L = L;
            this.G = G;
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