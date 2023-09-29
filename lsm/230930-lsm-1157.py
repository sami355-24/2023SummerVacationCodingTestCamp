from collections import defaultdict

dictionary = defaultdict(int)
string = input()
for c in string:
    dictionary[c.upper()]+=1

item = list(dictionary.items())
item.sort(key = lambda x: (x[1], x[0]), reverse = True)

if len(item) > 1 and item[0][1] == item[1][1]:
    print('?')
else:
    print(item[0][0])