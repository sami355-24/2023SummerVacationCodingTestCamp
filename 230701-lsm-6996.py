import sys
input = sys.stdin.readline

def sol():
    N = int(input())
    for n in range(N):
        A_origin, B_origin = input().split(" ")
        B_origin = B_origin[:-1]

        A_sort = sorted(A_origin)
        B_sort = sorted(B_origin)
        
        if A_sort == B_sort:
            print("{0} & {1} are anagrams.".format(A_origin, B_origin))
        else:
            print("{0} & {1} are NOT anagrams.".format(A_origin, B_origin))


sol()