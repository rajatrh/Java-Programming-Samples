class toh {
    public static void main(final String args[]) {
        towerOfHanoi(3, 'A', 'B', 'C');
    }

    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            // Last (biggest one) moves from source to dest
            System.out.println("Moving disk 1 from " + from + " to " + to);
            return;
        }
         // Move n-1 disks from source to aux peg
        towerOfHanoi(n-1, from, aux, to);

        System.out.println("Moving disk " + n + " from " + from + " to " + to);

        // Move the n-1 disks from aux to destination peg
        towerOfHanoi(n-1, aux, to, from);
    }
}