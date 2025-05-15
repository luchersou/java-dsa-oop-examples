package org.example.Algorithms.Search;

public class DFSDepthFirstSearch {
    public static List<Integer> dfs(int[][] graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];

        stack.push(startNode);
        visited[startNode] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            visitedNodes.add(currentNode);

            for (int neighbor : graph[currentNode]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return visitedNodes;
    }
}
