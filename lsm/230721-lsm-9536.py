import sys

input = lambda: sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):
    recordedSound = list(input().split(" "))
    while True:
        data = input()
        
        if data == "what does the fox say?":
            break

        data = data.split(" goes ")[1]
        
        cnt = recordedSound.count(data)
        for c in range(cnt):
            recordedSound.remove(data)
    
    print(" ".join(recordedSound))
