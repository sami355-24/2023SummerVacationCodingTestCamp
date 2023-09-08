from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
numbers = list(map(int, input().split(' ')))
temp = deque()
answer = []
for idx, number in enumerate(numbers):
    temp.append((idx+1, number))
numbers = temp

while True:
    number = numbers.popleft()
    answer.append(number[0])
    
    if not numbers:
        break

    if number[1] >=0 :
        for _ in range(number[1] - 1):
            temp = numbers.popleft()
            numbers.append(temp)
    
    elif number[1] <0:
        for _ in range(number[1], 0, +1):
            temp = numbers.pop()
            numbers.appendleft(temp)
print(' '.join(map(str, answer)))