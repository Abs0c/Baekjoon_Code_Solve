import sys
input = sys.stdin.readline

n = int(input())
arr = [1, 5, 10, 50]
ans = []
visited = [[] for _ in range(n+1)]
for i in arr:
    visited[0].append(i)
depth = 0

def funccc(depth, n):
    depth += 1
    if depth == n:
        return visited[depth-1]  
    for i in range(0, len(visited[depth-1]), 1):
        for j in arr:
            temp = j + visited[depth-1][i]
            if visited[depth].count(temp) == 0:
                visited[depth].append(temp)
    return funccc(depth, n)

temp = funccc(depth, n)
print(len(temp))