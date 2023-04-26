import java.util.*;

public class every_path {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int start = 0;

        Stack<Integer> path = new Stack<>();
        path.push(start);

        printAllPaths(matrix, 4, path);
    }

    //DFS
    public static void printAllPaths(int[][] graph, int end, Stack<Integer> path) {
        int currentVertex = path.peek();
        if (currentVertex == end) { // if we have reached the target vertex, print the path
            System.out.println(path);
        } else {
            for (int neighborIndex = 0; neighborIndex < graph[currentVertex].length; neighborIndex++) {
                int neighbor = graph[currentVertex][neighborIndex];
                if (neighbor == 1 && !path.contains(neighborIndex)) { // if the neighbor has not already been visited, add it to the path and continue recursively
                    Stack<Integer> newPath = new Stack<>();
                    newPath.addAll(path); // create a new path stack to avoid modifying the original path
                    newPath.push(neighborIndex); // add the neighbor to the path
                    printAllPaths(graph, end, newPath); // recursively find all paths from the neighbor to the target vertex
                }
            }
        }
        path.pop(); // backtrack by removing the current vertex from the path
    }
}
