import java.util.Scanner;

class TwoSum {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    
        double f1 = myObj.nextDouble();  // Read user input
        double f2 = myObj.nextDouble();

        myObj.close();
        double tf1, tf2;
        int res = 0;
        if (f1 > f2) {
            tf1 = f2;
            tf2 = f1;
        } else {
            tf1 = f1;
            tf2 = f2;
        }
        for (double curr = tf1; curr <= tf2; curr++){
            if(checkForZero(curr)) {
                res++;
            }
        }
        System.out.println(res-1);
    }

    public static boolean checkForZero(double num) {
        while(num > 0) {
            if (num%10 == 0) return false;
            num = (int)num/10;
        }

        return true;
    }
}