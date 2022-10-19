import sys
import collections
import heapq
input = sys.stdin.readline

n, m, k, x = map(int, input().split())
visited = [False] * (n+1)
graph = collections.defaultdict(list)

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append([b, 1])

distance = [1000000000] * (n+1)
visited[x] = True
distance[x] = 0
queue = [[0, x]]
heapq.heapify(queue)

while queue:
    a, b = heapq.heappop(queue)
    if distance[b] < a:
        continue
    for i in graph[b]:
        cost = a + i[1]
        if cost < distance[i[0]]:
            distance[i[0]] = cost
            heapq.heappush(queue, (cost, i[0]))

answer = []
for i in range(1, n+1):
    if distance[i] == k:
        answer.append(i)

if len(answer) == 0:
    print("-1")
else:
    for i in answer:
        print(i)
