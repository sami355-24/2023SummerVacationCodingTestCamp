import sys
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()

def calcMin(data):
    if len(data) == 9:
        data = data.split('/')
        DDD = int(data[0])*24*60
        data = data[1].split(':')
        hh = int(data[0])*60
        mm = int(data[1])
        return DDD + hh + mm
    
    else:
        month = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31]
        data = data.split(' ')
        yyyyMMdd = data[0]
        hhmm = data[1]
        
        yyyyMMdd = list(map(int, yyyyMMdd.split('-')))
        MM = 0
        for i in range(1, yyyyMMdd[1]):
            MM += month[i]
        MM *= 24*60
        dd = (yyyyMMdd[2]-1)*24*60
        
        hhmm = list(map(int, hhmm.split(':')))
        hh = hhmm[0]
        hh *= 60
        mm = hhmm[1]

        return MM + dd + hh + mm

N, L, F = list(input().split())
F = int(F)
L = calcMin(L)
lent_contents = defaultdict()
delay_users = defaultdict()

for _ in range(int(N)):
    data = input().split(' ')
    yyyyMMddhhmm = data[0] + ' ' + data[1]
    time = calcMin(yyyyMMddhhmm)
    parts = data[2]
    user = data[3]

    if not ((user, parts) in lent_contents):
        lent_contents[(user, parts)] = time
    else:
        estimate_time = time - lent_contents[(user, parts)]
        if estimate_time > L:
            if not (user in delay_users):
                delay_users[user] = 0
            delay_users[user] += (estimate_time - L) * F
        lent_contents.pop((user, parts))

if len(delay_users.keys()) == 0:
    print(-1)
else:
    items = sorted(delay_users.items())
    for user, price in items:
        print(user, price)
