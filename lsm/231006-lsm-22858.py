import sys
input = lambda:sys.stdin.readline().rstrip()

N, K = map(int, input().split())
S = [-1] + list(map(int, input().split()))
D = list(map(int, input().split()))

# i(idx)번째 카드를 Di(value)번째로 가져오는 작업

def shuffle_reverse(k):
    global S
    for _ in range(k):
        p = [0]*(N+1)
        for idx, value in enumerate(D):
            p[value] = S[idx+1]
        S = p


shuffle_reverse(K)
S = S[1:]
S = list(map(str, S))
print(' '.join(S))