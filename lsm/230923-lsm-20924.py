import sys
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**9)

def get_maxbranch(root):
    if root not in tree.keys():
        return 0
    
    branch_candidate = [0]
    for node, w in tree[root].items():
        del tree[node][root]
        branch_candidate.append(w + get_maxbranch(node))

    return max(branch_candidate)            
      

N, R = map(int, input().split())
tree = defaultdict(dict)
for _ in range(N-1):
    a, b, w = map(int, input().split())
    tree[a][b] = w
    tree[b][a] = w

giganode = R
gigalen = 0
while len(tree[giganode]) == 1:
    node, w = list(tree[giganode].items())[0]
    del tree[node][giganode]
    gigalen += w
    giganode = node

maxbranch = get_maxbranch(giganode)
print(gigalen, maxbranch)