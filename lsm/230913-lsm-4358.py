import sys
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()

dictionary = defaultdict(int)
total = 0

while True:
    tree = input()
    
    if not tree:
        break
    
    total += 1
    dictionary[tree] += 1

keys = sorted(list(dictionary.keys()))

for key in keys:
    value = dictionary[key]
    print('%s %.4f' %(key, value/total*100))
