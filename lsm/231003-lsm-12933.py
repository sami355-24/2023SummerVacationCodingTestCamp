quack = 'quack'
duck = input()
visited = [False]*len(duck)

def find(start):
    global cnt
    first = True
    j = 0

    for i in range(start, len(duck)):
        if duck[i] == quack[j] and visited[i] == False:
            visited[i] = True
            j+=1
            
            if duck[i] == 'k':
                j = 0
                if first:
                    first = False
                    cnt+=1
            


if len(duck)%5 != 0:
    print(-1)
    exit()

cnt = 0
for i in range(len(duck)):
    if duck[i] == 'q' and visited[i] == False:
        find(i)

if cnt == 0 or not all(visited):
    print(-1)

else:
    print(cnt)