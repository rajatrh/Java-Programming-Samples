public class ch2p5 {
    static int[][] direction = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
    static int[][] matrix;
    static int count = 0;
    static int maxSize = 0;
    static int size = 0;
    public static void main(String[] args) {
        matrix = new int[][] { { 0, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 0, 0, 0 }, { 0, 0, 1, 1 } };

        printMatrix();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    // System.out.println("Starting over at point : " + i + "  :: " + j);
                    count++;
                    size = 0;
                    findIslands(i, j);
                }
            }
        }

        System.out.println("Total Islands are: " + count);
        System.out.println("Max size: " + maxSize);

        printMatrix();
    }

    public static void findIslands(int r, int c) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (r >= m || c >= n || r < 0 || c < 0 || matrix[r][c] == -1 || matrix[r][c] == 0)
            return;

        matrix[r][c] = -1;
        // System.out.println("Striking over at point : " + r + "  :: " + c);
        size ++;
        // System.out.println("Size over : " + size);
        maxSize = Math.max(maxSize, size);

        for (int i=0; i < direction.length; i++) {
            findIslands(r + direction[i][0], c + direction[i][1]);
        }
    }

    public static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}