# def confirm(pattern):
#     i=0
#     length = len(pattern)

#     while i < length-1:

#         if i+1 < length and pattern[i] == '0' and pattern[i+1] == '1':
#             i += 2
#             continue

#         elif i+1 < length and pattern[i] == '1' and pattern[i+1] =='0':
#             i += 2
#             while i < length and pattern[i] == '0':
#                 i += 1
#                 continue

#             while i < length and pattern[i] == '1':
#                 i += 1
#                 continue

#         else:
#             return 0

#     return 1

    


# def sol():
#     answer = confirm(input())
#     if answer == 0: print("NOISE")
#     elif answer == 1: print("SUBMARINE")

# sol()

import re

def confirm(pattern):
    return bool(re.fullmatch('(100+1+|01)+', pattern))

def sol():
    answer = confirm(input())
    if answer:
        print("SUBMARINE")
    else:
        print("NOISE")

sol()
