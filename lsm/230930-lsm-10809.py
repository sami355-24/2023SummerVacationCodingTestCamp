string = input()
dic = dict()

for c in 'abcdefghijklmnopqrstuvwxyz':
    dic[c] = -1

for idx, c in enumerate(string):
    if dic[c] != -1:
        continue
    elif dic[c] == -1:
        dic[c] = idx

items = list(dic.items())
items.sort()
for item in items:
    print(item[1], end=' ')