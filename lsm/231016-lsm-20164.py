# 수의 각 자리 숫자 중에서 홀수의 개수를 종이에 적는다.
# 수가 한 자리이면 아무것도 못하고 종료한다.
# 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
# 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고 더한 값을 새로운 수로 생각한다.

# 풀이
# 모든 결과 값을 저장하는 set을 만든다.
# 현재 주어진 수가 한 자리 수가 될 때까지 반복한다.
# 만약 두 자리 이면 합을 구하여 재귀함수에 인자로 넘겨주면서 호출한다.
# 만약 3자리 이상이면 2중 반복문을 통해서 모든 가능한 경우의 수를 찾아 재귀함수를 호출한다.
# 모든 재귀 함수의 호출이 종료될 경우 set에서 최솟값과 최댓값을 출력한다.

import sys
sys.setrecursionlimit(10**8)
input = lambda: sys.stdin.readline().rstrip()

def pause():
    input()

def recursive(data, cnt):
    global candidate

    for num in data:
        if int(num) % 2 != 0:
            cnt += 1

    if len(data) == 1:
        candidate.add(cnt)
        return

    if len(data) == 2:
        recursive(list(str(int(data[0]) + int(data[1]))), cnt)
    
    else:
        for i in range(1,len(data)):
            for j in range(i+1, len(data)):
                pre = int(''.join(list(map(str, data[:i]))))
                mid = int(''.join(list(map(str, data[i:j]))))
                post = int(''.join(list(map(str, data[j:]))))
                temp = list(str(pre+mid+post))
                recursive(temp, cnt)

candidate = set()
N = list(input())
recursive(N, 0)
print(min(candidate), max(candidate))
