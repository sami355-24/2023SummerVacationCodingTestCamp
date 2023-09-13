import sys, heapq
input = lambda: sys.stdin.readline().rstrip()

minH, maxH = [], []
exists=[False]*100001
result = []
dictionary = dict()

N = int(input())
for n in range(N):
    P, L = map(int, input().split(' '))
    exists[P] = True
    heapq.heappush(minH, (L, P))
    heapq.heappush(maxH, (-L, -P))
    dictionary[P]=L

M = int(input())
for m in range(M):
    datas = input().split(' ')
    if datas[0] == 'recommend' and datas[1] == '-1':
        while (not (exists[minH[0][1]]) or
               not (minH[0][0] == dictionary[minH[0][1]])):
            heapq.heappop(minH)
        result.append(str(minH[0][1]))

    elif datas[0] == 'recommend' and datas[1] == '1':
        while (not (exists[-maxH[0][1]]) or
                not (-maxH[0][0] == dictionary[-maxH[0][1]])):
            heapq.heappop(maxH)
        result.append(str(-maxH[0][1]))

    elif datas[0] == 'add':
        P = int(datas[1])
        L = int(datas[2])
        exists[P] = True
        heapq.heappush(minH, (L, P))
        heapq.heappush(maxH, (-L, -P))
        dictionary[P]=L
    
    elif datas[0] == 'solved':
        P = int(datas[1])
        exists[P] = False

print('\n'.join(result))