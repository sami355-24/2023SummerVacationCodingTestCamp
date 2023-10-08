import sys
input = lambda: sys.stdin.readline()

N, K = map(int, input().rstrip().split())
map = [False]*(N+1)
for _ in range(K):
    x = int(input())
    now = x
    last_encounter = 0
    while x >= 1:
        if map[x] == True:
            last_encounter = x
        x //= 2
    if last_encounter == 0 :
        map[now] = True
        print(0)
    else:
        print(last_encounter)
    