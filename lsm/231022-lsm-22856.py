import sys
sys.setrecursionlimit(10**9)
input = lambda: sys.stdin.readline().rstrip()

def dfs1(now):
    global count
    visit[now] = True

    if not visit[graph[now][0]] and graph[now][0] != -1:
        dfs1(graph[now][0])
        count += 1

    if not visit[graph[now][1]] and graph[now][1] != -1:
        dfs1(graph[now][1])
        count += 1

def dfs2(now):
    global count2
    visit[now] = True

    if not visit[graph[now][1]] and graph[now][1] != -1:
        dfs2(graph[now][1])
        count2 += 1



N = int(input().rstrip())
graph = dict()

for _ in range(N):
    a,b,c = map(int, input().split())
    graph[a]=[b,c]

visit = [False] * (N+1)
count = 0
dfs1(1)

visit = [False] * (N+1)
count2 = 0
dfs2(1)

# print(count, count2)
print(2*count - count2)