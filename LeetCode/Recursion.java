class Recursion {
    public static void main(final String args[]) {
        int res = calulateGCD(6,2);
        System.out.println(res);
    }

    public int calculateGCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return calculateGCD(x, x%y);
    }


}