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
    -- linear ordering of vertices such that if there is an edge between u & v , u appears before that v in that ordering