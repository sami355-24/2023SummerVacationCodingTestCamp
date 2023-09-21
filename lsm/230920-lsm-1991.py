import sys
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()

def preorder(now):
    if now == '.':
        return
    print(now, end='')
    preorder(graph[now][0])
    preorder(graph[now][1])

def inorder(now):
    if now == '.':
        return
    inorder(graph[now][0])
    print(now, end='')
    inorder(graph[now][1])

def postorder(now):
    if now == '.':
        return
    postorder(graph[now][0])
    postorder(graph[now][1])
    print(now, end='')

graph = defaultdict(list) # key: 루트, value[0]: left, value[1]: right
N = int(input())
for _ in range(N):
    root, left_child, right_child = input().split()
    graph[root].append(left_child)
    graph[root].append(right_child)


preorder('A')
print()
inorder('A')
print()
postorder('A')
