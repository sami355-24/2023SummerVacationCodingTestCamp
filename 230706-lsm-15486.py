# import sys

# input = lambda: sys.stdin.readline()

# N = int(input().rstrip())
# T, P = [0 for _ in range(N+1)], [0 for _ in range(N + 1)]

# for i in range(1, N+1):
#     T[i], P[i] = map(int, input().split(" "))

# dp = [0 for _ in range(N+1)]

# for i in range(1, N+1):
#     dp[i] = max(dp[i-1], dp[i])
#     fin_date = i + T[i] -1
#     if fin_date <= N:
#         dp[fin_date] = max(dp[fin_date], dp[i-1] + P[i])

# print(dp)

import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
T, P = [0 for _ in range(N+1)], [0 for _ in range(N+1)]
dp =  [0 for _ in range(N+1)]

for idx in range(1, N+1):
    T[idx], P[idx] = map(int, input().split(" "))

for idx in range(1, N+1):
    dp[idx] = max(dp[idx], dp[idx-1])
    fin_date = idx + T[idx] - 1
    if fin_date <= N:
        dp[fin_date] = max(dp[fin_date], dp[idx-1] + P[idx])

print(max(dp))