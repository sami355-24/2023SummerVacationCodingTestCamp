from collections import defaultdict
import sys
input = lambda:sys.stdin.readline().rstrip()

def something(jump, cnt):
    i = 0
    while i< N:
        a[i] = a[i] + cnt
        i = i + jump

def sum(l, r):
    if l== 0:
        return pre[r]
    
    return pre[r] - pre[l-1]    

def preprocessing():
    for i in range(1, len(a)):
        pre[i] = pre[i-1] + a[i]

N, K = map(int, input().split())
a = [0 for _ in range(N)]
X = defaultdict(int)
datas = map(int, input().split(" "))
pre=[0 for _ in range(N)]

for i in datas:
    X[i] += 1

Q = int(input())


for jump, cnt in X.items():
    something(jump, cnt)

pre[0] = a[0]
preprocessing()

for i in range(Q):
    L, R = map(int, input().split(" "))
    print(sum(L, R))
