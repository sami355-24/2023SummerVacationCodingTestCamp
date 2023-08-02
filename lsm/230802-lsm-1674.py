import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
parent = [x for x in range(N+1)]
arr = []
sum = 0
last = 0
# candidate = []

def union(a, b):
    a = find(a)
    b = find(b)

    if a<b:
        parent[b] = a
    elif b<a:
        parent[a] = b

def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a])
    return parent[a]

for m in range(M):
    A, B, C = map(int, input().split(" "))
    arr.append((C, A, B))

arr.sort()

for c, a, b in arr:
    if find(a) != find(b):
        union(a, b)
        last = c
        sum += last
        # candidate.append(c)

print(sum-last)
# print(sum(candidate) - max(candidate))