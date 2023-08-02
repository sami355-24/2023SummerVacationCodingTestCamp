import sys
input = lambda: sys.stdin.readline().rstrip()

def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)

    if b<a:
        parent[a] = b
    else:
        parent[b] = a

N = int(input())
M = int(input())
arr = []
parent = [i for i in range(N+1)]
answer = 0

for i in range(M):
    a, b, c = map(int, input().split())
    arr.append((c, a, b))

arr.sort()

for dis, a, b in arr:
    if find(a) != find(b):
        union(a, b)
        answer += dis

print(answer)