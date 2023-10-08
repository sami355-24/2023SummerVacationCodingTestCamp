ja, mo = dict(), dict()

idx = 0
for c in 'qwert':
    ja[c] = (0, idx)
    idx+=1

for c in 'yuiop':
    mo[c] = (0, idx)
    idx+=1

idx = 0
for c in 'asdfg':
    ja[c] = (1, idx)
    idx+=1

for c in 'hjkl':
    mo[c] = (1, idx)
    idx+=1

idx = 0
for c in 'zxcv':
    ja[c] = (2, idx)
    idx+=1

for c in 'bnm':
    mo[c] = (2, idx)
    idx+=1

def calc(now, target):
    x1, y1 = now[0], now[1]
    x2, y2 = target[0], target[1]

    return abs(x1-x2) + abs(y1-y2)

LR = input()
L, R = LR[0], LR[2]
string = input()
answer = 0
for c in string:
    if c in ja:
        answer += calc(ja[L], ja[c]) + 1
        L = c
    else:
        answer += calc(mo[R], mo[c]) + 1
        R = c

print(answer)