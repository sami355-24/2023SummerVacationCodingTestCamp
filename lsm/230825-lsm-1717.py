import sys
input = lambda:sys.stdin.readline().rstrip()


def find_set(x):
    if x != parent[x]:
        parent[x] = find_set(parent[x])
    return parent[x]

def union_sets(a, b):
    root_a = find_set(a)
    root_b = find_set(b)
    
    if root_a != root_b:
        parent[root_b] = root_a


n, m = map(int, input().split())
parent = list(range(n+1))

for _ in range(m):
    cmd, a, b = map(int, input().split())
    if cmd == 1:
        if find_set(a) == find_set(b):
            print("yes")
        else:
            print("no")
    else:
        union_sets(a, b)