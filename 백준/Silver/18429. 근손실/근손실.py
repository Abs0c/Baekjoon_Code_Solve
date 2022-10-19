#import sys
#input = sys.stdin.readline
from itertools import combinations, permutations

n, k = map(int, input().split())
arr = list(map(int, input().split()))

perarr = list(permutations(arr, n))
cnt = len(perarr)
for i in range(0, len(perarr), 1):
    val = 500
    for j in range(0, n, 1):
        val = val - k + perarr[i][j]
        if val < 500:
            cnt -= 1
            break

print(cnt)