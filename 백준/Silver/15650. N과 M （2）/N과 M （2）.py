import sys
input = sys.stdin.readline
from itertools import permutations, combinations

n, m = map(int, input().split())
arr = []
for i in range(1, n+1):
    arr.append(i)

perarr = combinations(arr, m)

for i in perarr:
    for j in range(len(i)):
        print(i[j], end=' ')
    print()