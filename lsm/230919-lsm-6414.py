from collections import deque, defaultdict
import sys

# 표준 입력에서 한 줄을 읽는 함수를 줄여서 사용하기 위해 별칭을 설정합니다.
rl = sys.stdin.readline

# 테스트 케이스 카운트 변수 초기화
caseCnt = 0

# 간선 정보를 저장할 딕셔너리입니다.
Lines = defaultdict(list)

# 각 노드를 나타내는 클래스 정의
class Node():
    def __init__(self, item: int):
        self.item = item  # 노드의 값을 저장합니다.
        self.canGoTo = []  # 이 노드에서 다른 노드로 나가는 간선 정보를 저장합니다.
        self.canComeFrom = []  # 다른 노드에서 이 노드로 들어오는 간선 정보를 저장합니다.
        self.canFromRoot = False  # 루트 노드로부터 이 노드로 오는 경로가 있는지 여부를 저장합니다.

# 트리를 나타내는 클래스 정의
class Tree():
    def __init__(self, root: Node):
        self.root = root

    # 레벨 순회 (너비 우선 탐색) 함수
    def levelorder(self, n: Node):
        if n != None:
            queue = deque()
            queue.append(n)
            while queue:
                tmp = queue.popleft()
                if tmp.canFromRoot == False:
                    tmp.canFromRoot = True
                    for item in tmp.canGoTo:
                        global nodes
                        queue.append(nodes[item])

# 무한 반복문으로 입력을 계속 받습니다.
while 1:
    INP = rl().rstrip()

    # -1 -1이 입력된 경우 입력 종료
    if INP == '-1 -1':
        break

    # 빈 줄이 입력된 경우 무시
    elif INP == '':
        continue

    caseEnd = 0
    inputLine = list(map(int, INP.split()))

    # 입력으로 0 0이 들어올 때까지 간선 내용을 저장합니다.
    for i in range(0, len(inputLine), 2):
        u = inputLine[i]
        v = inputLine[i+1] 
        if u == 0 and v == 0:
            caseEnd = 1
            break
        else:
            Lines[u].append(v)


    # 입력으로 0 0이 들어온 경우 case 결과를 출력하고 입력을 초기화합니다.
    if caseEnd == 1:
        caseCnt += 1

        # key값이 node의 item인 node dict 생성
        nodes = dict()
        for u in Lines.keys():
            # 입력 내에서 간선의 출발점이 되는 정점을 노드로 추가
            if not u in nodes.keys():
                nodes[u] = Node(u)

            for v in Lines[u]:
                # 입력 내에서 간선의 도착점이 되는 정점을 노드로 추가
                if not v in nodes.keys():
                    nodes[v] = Node(v)

                # 정점으로 들어오는 간선 정보를 도착 정점 노드에 추가
                nodes[v].canComeFrom.append(u)
                # 정점에서 나가는 간선 정보를 출발 정점 노드에 추가
                nodes[u].canGoTo.append(v)

        root = None
        isTree = True

        # ==============================<<1. 루트 노드가 존재하는지 확인 >>==============================
        for nodeItem in nodes.keys():
            # 1. 들어오는 간선이 하나도 없는 단 하나의 노드가 존재한다. 이를 root 노드라 부릅니다.
            if len(nodes[nodeItem].canComeFrom) == 0:
                if root == None:
                    root = nodeItem
                # 만약 들어오는 간선이 하나도 없는 노드를 찾았는데 root가 이미 있으면, case를 false로 종료합니다.
                else:
                    isTree = False
                    break

        # 만약 들어오는 간선이 하나도 없는 노드가 없다면, case를 false로 종료합니다.
        if root == None:
            isTree = False
        # ========================================================================================



        # ==============================<<2. 단 하나의 들어오는 간선만 존재하는지 확인 >>==============================
        if isTree:
            for nodeItem in nodes.keys():
                # 2. 루트 노드를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재합니다.
                if len(nodes[nodeItem].canComeFrom) != 1 and nodeItem != root:
                    isTree = False
                    break
            # 루트 노드로 들어오는 간선이 존재하면, case를 false로 종료합니다.
            if len(nodes[root].canComeFrom) > 0:
                isTree = False
        # ===================================================================================================


        # ==============================<< 루트 노드에서 다른 노드로 갈수있으며 유일해야 할때 >>==============================
        # 1번과 2번을 만족하면, 일단 트리 형태를 만들 수 있는데, 3번 형태가 만족되지 않는 것은 트리에서 연결되지 않은 노드가 존재하지 않는다는 뜻이기 때문에, 트리를 순회하여 Node의 방문 여부를 체크하고, 순회가 종료된 뒤에 canFromRoot가 False인 Node가 존재하면 트리가 아니라고 출력합니다.
        if not Lines: # 빈 트리도 트리다.
            isTree = True
        if isTree and Lines:
            tree = Tree(nodes[root])
            tree.levelorder(nodes[root])
            for nodeItem in nodes.keys():
                if nodes[nodeItem].canFromRoot == False:
                    isTree = False
                    break
        # =======================================================================================================

        if isTree:
            print('Case ' + str(caseCnt) + ' is a tree.')
        else:
            print('Case ' + str(caseCnt) + ' is not a tree.')

        Lines = defaultdict(list)