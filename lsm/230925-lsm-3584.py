import sys
from collections import defaultdict
sys.setrecursionlimit(10**9)
input = lambda:sys.stdin.readline().rstrip()

tree = defaultdict(dict)
T = int(input())
answer = 0

def DFS(node):
    global answer
    visit[node] = True

    for parent in tree[node].keys():
        if visit[parent] == False:
            visit[parent] = True
            DFS(parent)
        else:
            answer = parent
            return

for t in range(T):
    N = int(input())
    visit = [False] * (N+1)
    for n in range(N-1):
        parnet, child = map(int, input().split())
        tree[child][parnet] = 1
    
    A, B = map(int, input().split())
    DFS(A)
    DFS(B)
    print(answer)
    tree.clear()
