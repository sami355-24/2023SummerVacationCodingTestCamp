import sys
from collections import defaultdict, deque
input = lambda: sys.stdin.readline().rstrip()

system = defaultdict(dict)
N, M = map(int, input().split())
for _ in range(N+M):
    P, F, C = input().split()
    if P not in system.keys():
        system[P]["Folder"] = set()
        system[P]["File"] = set()

    if C == "1":
        system[P]["Folder"].add(F)
    else :
        system[P]["File"].add(F)


Q = int(input())
for _ in range(Q):
    File = []
    query = list(input().split("/"))
    q = deque()
    q.append(query[-1])
    
    while q:
        now = q.popleft()
        if "File" in system[now]:
            File.extend(system[now]["File"])
        if "Folder" in system[now]:
            q.extend(system[now]["Folder"])
    
    print(len(set(File)), len(File))
    input()