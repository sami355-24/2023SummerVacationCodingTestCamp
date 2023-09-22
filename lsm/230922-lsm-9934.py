import sys
input = lambda:sys.stdin.readline()

K = int(input())
args = list(map(int, input().split()))
tree = [[] for _ in range(K)]

def makeTree(arr, x):
    mid = len(arr)//2
    tree[x].append(arr[mid])
    if len(arr) == 1:
        return
    makeTree(arr[:mid], x+1)
    makeTree(arr[mid+1:], x+1)

makeTree(args, 0)
for i in range(K):
    print(*tree[i])
