import sys
input = lambda:sys.stdin.readline().rstrip()

string = input()
m = 0
Max = ''
Min = ''

for s in string:
    if s == 'M':
        m+=1
    else: #s가 'K'일때
        if m > 0:
            Max += str((10**m) * 5)
            Min += str(10**m + 5)
        else:
            Max += '5'
            Min += '5'
        m = 0

if m >0:
    Max += str('1'*(m))
    Min += str(10**(m-1))

print(Max)
print(Min)
