# import sys
# input = lambda:sys.stdin.readline().rstrip() # 빠른 입력
# sys.setrecursionlimit(int(1e5)) #재귀 함수 깊이 수정
# LOG = 21 # 최대 depth 설정

# n = int(input()) # 노드 개수 입력
# parent = [[0]*LOG for _ in range(n+1)] # 부모 노드 정보 2의 제곱승
# d = [0] * (n+1) # 루트노드에서 각 노드까지의 깊이 (각 노드의 depth 계산)
# c = [0] * (n+1) # 각 노드 깊이가 계산되었는지 여부

# graph = [[]for _ in range(n+1)]

# for _ in range(n-1):
#     a, b = map(int, input().split())
#     graph[a].append(b)
#     graph[b].append(a)


# # 루트 노드부터 출발하여 깊이를 구하는 함수
# def dfs(x, depth):
#     c[x] = True
#     d[x] = depth
#     for y in graph[x]:
#         if c[y]:
#             continue
#         parent[y][0] = x # 한 칸위의 부모 설정
#         dfs(y, depth + 1)

# def set_parent():
#     dfs(1, 0)
#     for i in range(1, LOG): # 노드의 최대 개수만큼 순회 하겠다.
#         for j in range(1, n+1): # 입력으로 들어온 모든 노드를 돌겠다.
#             parent[j][i] = parent[parent[j][i-1]][i-1] 
#             # {(j번째 노드의 2^i번째 부모)}는 {(j의 2^(i-1)번째 부모)의 ((i-1)번째 부모와 같다)}.

# def lca(a,b):
#     if d[a] > d[b]:
#         a, b = b, a
    
#     for i in range(LOG-1, -1, -1):
#         if d[b] - d[a] >= (1<<i):
#             b = parent[b][i]
    
#     if a == b:
#         return a
#     for i in range(LOG -1, -1, -1):
#         if parent[a][i] != parent[b][i]:
#             a = parent[a][i]
#             b = parent[b][i]
    
#     return parent[a][0]

# set_parent()

# m = int(input())

# for i in range(m):
#     a,b = map(int, input().split())
#     print(lca(a,b))

total = 0
for i in range(16):
    total += 2**i

print(total)
