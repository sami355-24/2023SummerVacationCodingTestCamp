import sys
from collections import defaultdict
sys.setrecursionlimit(500001)
input = lambda: sys.stdin.readline().rstrip()

def dfs(now, depth):
    global count, tree

    for x in tree[now]:
        if visit[x] == False:
            visit[x] = True
            count[x] = depth+1
            dfs(x, depth + 1)


tree = defaultdict(list)
N = int(input())
count = [0] * (N+1)
visit = [False]*(N+1)
sum = 0

for _ in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

visit[1] = True
dfs(1, 0)
for x in tree.keys():
    if x != 1 and len(tree[x]) == 1:
        sum += count[x]
if sum%2 == 0:
    print('No')
else:
    print('Yes')
