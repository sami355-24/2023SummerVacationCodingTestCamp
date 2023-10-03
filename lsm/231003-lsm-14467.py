cow = dict()

answer = 0
N = int(input())
for _ in range(N):
    num, pos = map(int, input().split())
    if num in cow.keys() and cow[num] != pos:
        answer += 1
    
    cow[num] = pos
    
print(answer)