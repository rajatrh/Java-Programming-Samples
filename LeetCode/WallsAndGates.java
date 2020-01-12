import java.util.*;

class Solution {
    private static final int EMPTY_ROOM = Integer.MAX_VALUE;
    private static final int GATE = 0;
    
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 0, -1}
    );
    
    public static void wallsAndGates(final int[][] rooms) {
        // Get a list of all the gates
        final Queue<int[]> q = new LinkedList<>();
        // rows
        final int m = rooms.length;
        // columns
        final int n = rooms[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }

        printq(q);

        while (!q.isEmpty()) {

            final int[] coord = q.poll();
            final int r = coord[0], c = coord[1];

            for (final int[] dir : DIRECTIONS) {
                final int nr = r + dir[0];
                final int nc = c + dir[1];

                if (nc < 0 || nr < 0 || nc >= n || nr >= m || rooms[nr][nc] != EMPTY_ROOM) {
                    continue;
                }
                // Debug
                printRoom(rooms, m,n);
                System.out.print("\n++++++++++++++++++++++++++++\n");
                // Increment the distance by 1
                rooms[nr][nc] = rooms[r][c] + 1;
                q.add(new int[] { nr, nc });
            }
        }

    }

    public static void printq(final Queue<int[]> q) {
        for (final int[] arr : q) {
            System.out.println(arr[0] + " <-> " + arr[1]);
        }
    }

    public static void printRoom(int[][] rooms, int m, int n) {
        for (int row = 0; row < m; row++) {
            System.out.print("\n");
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == EMPTY_ROOM) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" " + rooms[row][col] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = new int[][] {
            new int[] {2147483647,-1,0,2147483647},
            new int[] {2147483647,2147483647,2147483647,-1},
            new int[] {2147483647,-1,2147483647,-1},
            new int[] {0,-1,2147483647,2147483647}
        };

      
      wallsAndGates(rooms);
      printRoom(rooms, 4, 4);
    }
}