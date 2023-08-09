package Concept;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static boolean[] visited = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args) {
        bfs(1);
    }

    static void bfs(int nodeIndex) {
        visited[nodeIndex] = true;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(nodeIndex);

        while(!q.isEmpty()) {
            int nextNode = q.poll();
            visited[nextNode] = true;
            System.out.print(nextNode + " -> ");

            for(int node : graph[nextNode]) {
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
    }

}
