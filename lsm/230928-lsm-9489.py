import sys
input = lambda:sys.stdin.readline().rstrip()

while True:
    n,k = map(int, input().split())
    if n==0 and k == 0:
        break

    args = [-1] + list(map(int, input().split()))

    parent = [0] * (n+1)
    parent[0] = -1

    target = 0
    idx = -1
    for i in range(1, n+1):
        if args[i] == k:
            target = i
        
        if args[i] != args[i-1] + 1:
            idx += 1
        
        parent[i]=idx

    answer = 0

    for i in range(1, n+1):
        if parent[i] != parent[target] and parent[parent[i]] == parent[parent[target]]:
            answer += 1 
    print(answer)