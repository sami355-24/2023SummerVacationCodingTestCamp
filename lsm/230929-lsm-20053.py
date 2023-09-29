import sys
input = lambda:sys.stdin.readline()

T = int(input())
for _ in range(T):
    N = int(input())
    args = list(map(int, input().split()))
    print(min(args), max(args))