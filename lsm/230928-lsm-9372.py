import sys
input = lambda: sys.stdin.readline()

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    for m in range(M):
        input()
    
    print(N-1)