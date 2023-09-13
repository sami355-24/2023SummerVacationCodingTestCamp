import sys
input = lambda: sys.stdin.readline().rstrip()

arr = []
N = int(input())
for n in range(N):
    arr.extend(list(map(int, input().split(' '))))  
    arr.sort(reverse = True)
    arr = arr[0:N]

print(arr[-1])