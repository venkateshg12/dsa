Directed Graph ----> having arrows (direction).
Undirected Graph ----> no arrows (no direction).
Path ----> contain a lot of nodes and each of them are reachable.
degrees in graph ----> number of edges attached to a node.
total degree of a graph == 2 * no of edges (E).
For directed graph..
indegree (no of incoming edges).
outdegree (no of outgoing edges).
Connected Components ---> A group of vertices (nodes) where every node is reachable from every other node in that group.

Breadth First Search(BFS):
    -- an traversal algorithm that explores node level by level
    -- FIFO
    -- Queue data structure ( linear, follows FIFO)

Depth First Search(DFS):
    -- a graph traversal algorithm that explores as far as possible along each backtracking.

Bipartite Graph:
    -- The division of all vertices into 2 groups such that no two vertices (adjacent vertices) have same color.
    -- linear graphs are always bipartite graph.
    -- Any graph with odd cycle length can never be a bipartite graph (non - bipartite graph).
    -- Any graph with even cycle length can  be a bipartite graph.

Topological Sorting:
    -- only exists on directed acyclic graph.
    -- linear ordering of vertices such that if there is an edge between u & v , u appears before that v in that ordering.

Dijkstra's Algorithm: 
    -- Dijkstra’s Algorithm is a graph algorithm used to find the shortest path from a single source node to all other nodes in a weighted graph.
    -- All weights are non-negative
    -- Undirected graphs
    -- Directed graphs
    -- Graphs that contain cycles
    -- dosn't work on negative weights or cycles.(fall into an infinite loop)
    -- We are using here PriorityQueue here because, if we use queue also we get answer but using Queue leads to unecessary path checks leading to going through all iterations of  the paths  and takes more time complexity.

Bellman Ford Algorithm.
    -- while dijkstra algo fails on negative edge weights and negative cycles.
    -- helps to detect negative edge cycles.
    -- used to find the shortest path from a single source vertex to all other vertices in a weighted graph, even when   negative edge weights exist.

Floyd Warshal Algorithm.
    -- finds the shortest distance between every pair of vertices in a weighted graph.
    -- multisource shortest path algorithm.
    -- go via every node
    -- helps to detect negative edge cycles.

Spanning Tree
    -- a tree in which we have n nodes and n - 1 edges and all nodes reachable from each other.

Minimum Spanning Tree
    -- having least sum edge weight is known as Minimum Spanning Tree.

Prim's Algorithm
    -- helps to find the minimum spanning tree.