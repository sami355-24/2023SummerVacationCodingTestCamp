package Conception;

public class DFS {
    static boolean[] visited = new boolean[9];

    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args) {
        dfs(1);
    }

    static void dfs(int nodeIndex) {
        visited[nodeIndex] = true;

        System.out.print(nodeIndex + " -> ");

        for(int node : graph[nodeIndex]) {
            if(!visited[node]) {
                dfs(node);
            }
        }
    }
}