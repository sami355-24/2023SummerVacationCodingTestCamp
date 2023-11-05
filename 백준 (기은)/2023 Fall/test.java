import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        Problem p1 = new Problem(1402, 59);
        Problem p2 = new Problem(2042, 55);

        TreeMap<Integer, Problem> p1 = new TreeMap<>();
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
