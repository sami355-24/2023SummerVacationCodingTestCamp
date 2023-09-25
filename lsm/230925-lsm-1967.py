import sys
from collections import defaultdict
input=lambda:sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**9)

def dfs(node, weight):
    for next_node, next_weight in tree[node].items():
        calc_weight = weight + next_weight
        if visited[next_node] == -1:
            visited[next_node] = calc_weight
            dfs(next_node, calc_weight)

tree = defaultdict(dict)
n = int(input())
for _ in range(n-1):
    u, v, weight = map(int, input().split())
    tree[u][v] = weight
    tree[v][u] = weight

visited = [-1]*(n+1)
visited[1] = 0
dfs(1, 0)
temp = max(visited)
idx = visited.index(temp)

visited = [-1]*(n+1)
visited[idx] = 0
dfs(idx, 0)

print(max(visited))