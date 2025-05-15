package org.example.Algorithms.Search;

public class BFSBreadthFirstSearch {
    private int vertices;
    private LinkedList<Integer>[] adj;

    public BFS(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void performBFS(int startNode) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (queue.size() != 0) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            Iterator<Integer> i = adj[currentNode].listIterator();
            while (i.hasNext()) {
                int nextNode = i.next();
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}
