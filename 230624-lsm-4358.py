import sys
input = sys.stdin.readline

def sol():
    D = dict()
    NumberOfTree = 0
    while True:
        Tree = input().rstrip()
        if not Tree:
            break

        if Tree in D:
            D[Tree] += 1
        else:
            D[Tree] = 1
        NumberOfTree += 1

    Datas = list(D.keys())
    Datas.sort()

    for Data in Datas:
        print('%s %.4f' %(Data, D[Data]/NumberOfTree*100))

sol()