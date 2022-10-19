import sys
input = sys.stdin.readline

n, m, r = map(int, input().split())
arr = [[] for _ in range (n+1)]

for i in range(0, m, 1):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
        
def dfs(graph, root, size):
    stack = [root]
    visited = [0 for _ in range(size+1)]
    ansind = 1
    while stack:
        mm = stack.pop()       
        if visited[mm] == 0:
            visited[mm] = ansind
            ansind += 1
            if len(graph[mm]) != 0:
                stack += graph[mm]
    return visited

for i in range(0, n+1, 1):
    arr[i].sort(reverse=True)

temp = dfs(arr, r, n)
for i in range(1, len(temp), 1):
    print(temp[i])