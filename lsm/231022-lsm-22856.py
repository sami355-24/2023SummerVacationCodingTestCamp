import sys
sys.setrecursionlimit(10**9)
input = lambda : sys.stdin.readline().rstrip()

L, R = 0, 1
N = int(input())
Tree = dict()

def dfs1(now):
    global cnt1
    visit[now] = True

    if Tree[now][L] != -1 and visit[Tree[now][L]] == False:
        cnt1+=1
        dfs1(Tree[now][L])

    if Tree[now][R] != -1 and visit[Tree[now][R]] == False:
        cnt1+=1
        dfs1(Tree[now][R])

def dfs2(now):
    global cnt2
    visit[now] = True

    if Tree[now][R] != -1 and visit[Tree[now][R]] == False:
        cnt2+=1
        dfs2(Tree[now][R])

for _ in range(N):
    a, b, c = map(int, input().split())
    Tree[a] = [b,c]

visit = [False] * (N+1)
cnt1 = 0
dfs1(1)

visit = [False] * (N+1)
cnt2 = 0
dfs2(1)

print(2*cnt1 - cnt2)