public class ch2p4 {
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[2];
        generateString(2, 5);
    }

    public static void generateString(int n, int k) {
        if (n < 1) {
            for (int j=0; j < arr.length; j++) {
                System.out.print(arr[j]);
            }
            System.out.print("\n");
            return;
        }

        for (int i=0; i<k; i++) {
            arr[n-1] = i;
            generateString(n-1, k);
        }
    }
}