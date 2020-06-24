public class ch2p3binary {
    static int[] arr = new int[3];
    public static void main(final String args[]) {
        
        genBinary(3);
    }

    public static void genBinary(int n) {
        if (n < 1) {
            for (int i=0; i <arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.print("\n");
            
            return;
        }
        arr[n-1] = 0;
        genBinary(n-1);
        arr[n-1] = 1;
        genBinary(n-1);
    }
}