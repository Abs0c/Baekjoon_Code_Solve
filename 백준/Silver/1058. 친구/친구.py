n = int(input())

arr = []

for i in range(n):
    arr.append(input())

graph = [[0] * n for i in range(n)]

for i in range(n):
    cnt = 0
    for j in range(n):
        for k in range(n):
            if j == k:
                continue
            if arr[j][k] == "Y" or (arr[j][i] == "Y" and arr[i][k] == "Y"):
                graph[j][k] = 1

result = 0
for i in range(n):
    cnt = 0
    for j in range(n):
        if graph[i][j] == 1:
            cnt += 1
        result = max(result,cnt)
print(result)