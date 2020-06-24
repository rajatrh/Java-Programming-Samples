class checkSortedOrder {
    static int[] a = new int[]{4,5,6,12,17,25};
    public static void main(final String args[]) {
        
        System.out.println(cc(a.length));
    }

    public static boolean cc(int n) {
        if (n == 1) {
            return true;
        }
        // check two numbers and recurse for the rest of the array
        return a[n-1] > a[n-2] && cc(n-1);
    }
}