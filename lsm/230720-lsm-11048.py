import sys

input = lambda:sys.stdin.readline().rstrip()

N, M =  map(int, input().split(" "))

maze = [[0]*(M+1) for _ in range(N+1)]
dp = [[0]*(M+1) for _ in range(N+1)]
answer = 0

for n in range(1, N+1):
    datas = list(map(int, input().split(" ")))
    for m in range(1, M+1):
        maze[n][m] = datas[m-1]
        dp[n][m] = max(dp[n-1][m], dp[n-1][m-1], dp[n][m-1]) + maze[n][m]
        if dp[n][m] > answer:
            answer = dp[n][m]

print(answer)