import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]
group = []
ans=0

n, m = tuple(map(int, input().split()))
board = [list(map(int, input().split())) for _ in range(n)]

def inRange(x, y):
    return 0 <= x < n and 0 <= y < m

def bfs(startX,startY):
    board[startX][startY] = 3
    cnt = 0

    q = deque([(startX,startY)])
    needs = set()
    while q:
        x,y= q.popleft()
        cnt += 1

        for dx , dy in zip(dxs,dys):
            nx=x+dx
            ny=y+dy

            if inRange(nx , ny):
                # 다음 칸이 비어있는 경우 비어 있는 칸을 집합에 넣는다.
                if (nx , ny) not in needs and board[nx][ny] == 0:
                    needs.add((nx , ny))

                # 만약 상대편 돌(2)라면 방문했다고 표시를 해놓는다.(3으로 방문 표시해놓음)
                if board[nx][ny] ==2:
                    board[nx][ny]=3
                    q.append((nx , ny))
    
   # 현재 그룹을 잡아먹기 위해 필요한 칸이 2칸 이하인 경우 즉 2칸 이하일 경우 현재 그룹을 잡아 먹을수 있기에 group에 추가해둔다. 
    if len(needs) <=2:
       group.append((needs,cnt))

# shell_cnt: 현재까지 선택한 돌의 개수를 나타내는 변수입니다.
# start: 그룹들을 조합하기 위한 시작 인덱스를 나타냅니다.
# edges: 이미 선택한 빈칸들의 위치를 저장하는 집합 
# 초기값 combi(0 , 0, set())
def combi(shell_cnt, start, edges):
     global ans
     
     # 만약 현재 선택한 칸의 개수가 2초과 라면 문제의 조건을 벗어나기에 return
     if len(edges)>2 :
         return 

    # 현재 선택한 상대편 돌의 개수와 ans를 비교해서 큰쪽을 골라서 ans를 업데이트
     ans=max(ans, shell_cnt)

     for i in range(start, len(group)):
         # 현재 edges(이미 선택한 빈칸의 위치들의 집합)의 복사본을 만든다.
         cur_set=set(edges)
         
         for e in group[i][0]:
             cur_set.add(e)

         combi(shell_cnt+group[i][1] ,i+1 ,cur_set)


for i in range(n):
   for j in range(m):
       if board[i][j]==2 :
           bfs(i,j)

combi(0 , 0, set())

print(ans)
