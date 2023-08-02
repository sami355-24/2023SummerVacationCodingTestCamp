import sys, itertools

input = lambda: sys.stdin.readline().rstrip()
N, L, R, X = map(int, input().split())
answer = 0

A = list(map(int, input().split(" ")))

for n in range(2, N+1):
    # print("n : {0}".format(n))
    for a in (itertools.combinations(A, n)) :
        # print(" a : {0}".format(a))
        # print("     L : {0} || R : {1} || sum(a) : {2}".format(L, R, sum(a)))
        if L <= sum(a) <= R:
            if max(a) - min(a) >= X:
                answer += 1
print(answer)