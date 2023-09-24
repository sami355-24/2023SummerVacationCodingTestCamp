import sys
input =  sys.stdin.readline

def dfs(x):
    nodes[x] = -2
    for i in range(len(nodes)):
        if x == nodes[i]:
            dfs(i)

N = int(input())
nodes = list(map(int, input().split()))
k = int(input())
dfs(k)

answer = 0
for i in range(len(nodes)):
    if nodes[i] != -2 and i not in nodes:
        answer +=1
print(answer)