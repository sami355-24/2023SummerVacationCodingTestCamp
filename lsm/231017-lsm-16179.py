import sys
input = lambda: sys.stdin.readline().rstrip()

arr = list(input())
result = ['']*len(arr)

def solution(arr, start):
    if not arr:
        return
    
    min_value = min(arr)
    min_idx = arr.index(min_value)
    result[start+min_idx] = min_value
    print(''.join(result))

    solution(arr[min_idx+1:], start+min_idx+1)
    solution(arr[:min_idx], start)

solution(arr, 0)