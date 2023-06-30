def sol(a):
    dp = [-1 for _ in range(100001)]
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1
    dp[5] = 1
    dp[7] = 1


    for i in range(1, a+1):

        if i==1 or i==2 or i==5 or i==7:
            continue

        if i>7:
            dp[i] = min(dp[i-7], dp[i-5], dp[i-2], dp[i-1]) + 1

        elif i>5:
            dp[i] = min(dp[i-5], dp[i-2], dp[i-1]) + 1

        elif i>2:
            dp[i] = min(dp[i-2], dp[i-1]) + 1

        elif i>1:
            dp[i] = dp[i-1]+1
    print(dp[a])


data = int(input())
sol(data)
