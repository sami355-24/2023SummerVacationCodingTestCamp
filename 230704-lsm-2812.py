import sys

input = sys.stdin.readline

N, K = map(int, input().split(" "))
data = list(map(int, list(input()[:-1])))

while K>0:
    for idx in range(N-1):
        if data[idx] < data[idx+1]:
            del data[idx]
            K -= 1
            N -= 1
            break

    for idx in range(N-1, 0, -1):
        if data[idx-1] > data[idx]:
            del data[idx]
            K -= 1
            N -= 1
            break
        
    
    

    pass