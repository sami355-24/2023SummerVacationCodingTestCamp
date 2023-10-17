import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
calendar = [0]*367
answer = 0

for _ in range(N):
    s, e = map(int, input().split())
    for i in range(s, e+1):
        calendar[i] += 1

i = 0
start_idx = -1
end_idx = -1

while i<=365:
    i += 1

    if start_idx == -1 and calendar[i] != 0 and calendar[i-1] == 0:
        start_idx = i
    
    if end_idx == -1 and calendar[i] != 0 and calendar[i+1] == 0:
        end_idx = i
        height = max(calendar[start_idx: end_idx+1])
        width = end_idx - start_idx + 1    
        answer += height * width
        start_idx = -1
        end_idx = -1

print(answer)