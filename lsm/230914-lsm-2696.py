import sys, heapq
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for t in range(T):
    M = int(input())
    seq = []

    if M%10 == 0:
        for _ in range(M//10):
            seq.extend(list(map(int, input().split())))
    else:
        for _ in range(M//10+1):
            seq.extend(list(map(int, input().split())))


    median = 0
    cnt = 0
    maxH, minH = [], []
    answer = []

    # 인덱스가 짝수일때 중앙값 처리
    for idx, num in enumerate(seq):
        if idx == 0:
           median = num
           cnt += 1 
           answer.append(str(median))
           continue
        
        if num <= median:
            heapq.heappush(maxH, -num)

        elif median < num:
            heapq.heappush(minH, num)
        
        if idx%2 == 0:
            if len(maxH) > len(minH):
                heapq.heappush(minH, median)
                median = -heapq.heappop(maxH)
            elif len(maxH) < len(minH):
                heapq.heappush(maxH, -median)
                median = heapq.heappop(minH)
            cnt+=1
            answer.append(str(median))

    print(cnt)
    for i in range(len(answer)):
        if i!=0 and (i+1)%10==1:
            print()
        print(answer[i], end=' ')
    print()