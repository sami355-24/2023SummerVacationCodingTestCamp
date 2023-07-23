import sys
from itertools import permutations
input = lambda: sys.stdin.readline().rstrip()

N = int(input())

for c in permutations(list(range(1, N+1)), N):
    c = [str(x) for x in c]
    print(" ".join(c))