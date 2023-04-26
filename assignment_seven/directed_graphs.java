public class directed_graphs {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 1},
                {0, 0, 0, 0}};

        int isDirected = 0;
        // Check if the matrix represents a directed graph
        for (int i = 0; i < matrix.length && isDirected == 0; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0 && matrix[j][i] == 0) {
                    isDirected = 1;
                    break;
                }
            }
        }

        if (isDirected == 1) {
            System.out.println("Directed Graph");
        } else {
            System.out.println("Undirected Graph");
        }
    }
}
