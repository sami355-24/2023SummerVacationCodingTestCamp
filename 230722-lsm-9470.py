import sys
from collections import deque, defaultdict
input = sys.stdin.readline
 
T = int(input())
for _ in range(T):
    K, M, P = map(int, input().split())
    indegree = [[0, 0, 0] for _ in range(M+1)] # [진입차수, 최대레벨, 최대레벨 개수]
    ndict = defaultdict(list)

    for _ in range(P):
        s, e = map(int, input().split())
        ndict[s].append(e) # 방향이 있기에 출발하는 쪽의 노드에만 추가
        indegree[e][0] += 1 # 도착하는 노드의 진입차수 증가
 
    queue = deque() 
    for i in range(1, M+1):
        if indegree[i][0] == 0: #만약 진입 차수가 0이면 큐에 넣고 최대 레벨을 1로 잡는다. (문제에서 그렇게 요구했기 때문)
            queue.append(i)
            indegree[i][1] = 1
 
    while queue:
        x = queue.popleft() # 큐에서 빼내면서
        for i in ndict[x]: 
            indegree[i][0] -= 1 # 큐에서 빼낸 노드와 연결되어 있는 노드와의 연결고리를 끊는다.
            if indegree[i][1] < indegree[x][1]: # 큐에서 빼낸 노드와 해당 노드와 연결되어 있는 노드간의 최대 레벨들 비교한다.
                indegree[i][1] = indegree[x][1]
                indegree[i][2] = 1 # 연결되어있는 노드의 최대 레벨 개수 조정

            elif indegree[i][1] == indegree[x][1]:
                indegree[i][2] += 1 # 만약 큐에서 빼낸 노드와 해당 노드와 연결되어 있는 노드간의 최대 레벨을 비교하고 같다면 +1
            
            if indegree[i][0] == 0: # 만약 진입 차수가 0인 노드를 발견했을 경우
                if indegree[i][2] > 1: # 최대 레벨의 개수가 2개 이상일 경우
                    indegree[i][1] += 1 # 현재 노드의 최대 레벨을 증가시킨다.
                queue.append(i) # 해당 노드를 큐에 넣는다.
 
    print(K, indegree[M][1])